package com.nhfc99.template.component.SocketClient;

import com.nhfc99.template.config.VRDeviceType;
import com.nhfc99.template.domain.DeviceipinfoDomain;
import com.nhfc99.template.service.DeviceipinfoService;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.nhfc99.template.component.tools.ToolObject.getStrList;

@Slf4j
//@Component
public class SocketClient implements ApplicationRunner {
    @Autowired
    DeviceipinfoService deviceipinfoService;

    public static boolean retryConnectFlag = false;

    private EventLoopGroup loop = new NioEventLoopGroup();

    public static boolean connectFlag = false;

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    /**
     * netty client 连接，连接失败10秒后重试连接
     */
    public void doConnect(Bootstrap bootstrap, EventLoopGroup eventLoopGroup) {
        ChannelFuture future = null;
        try {
            DeviceipinfoDomain deviceipinfoDomain = deviceipinfoService.selectByName(VRDeviceType.kPlay);
            if (deviceipinfoDomain == null) {
                log.info("Socket Client 还没有配置成功!");
                Thread.sleep(5000);
                doConnect(new Bootstrap(), loop);
                return;
            }
            if (bootstrap != null) {
                bootstrap.group(eventLoopGroup);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
                bootstrap.handler(new ClientHandler());
                int port = (int) Long.parseLong(deviceipinfoDomain.getPort());
                bootstrap.remoteAddress(deviceipinfoDomain.getIp(), port);
                future = bootstrap.connect().addListener((ChannelFuture futureListener) -> {
                    final EventLoop eventLoop = futureListener.channel().eventLoop();
                    if (!futureListener.isSuccess()) {
                        log.warn("客户端已启动，与服务端建立连接失败,10s之后尝试重连!");
                        eventLoop.schedule(() -> doConnect(new Bootstrap(), eventLoop), 10, TimeUnit.SECONDS);
                    } else {
                        connectFlag = true;
                        log.info("客户端已启动成功,port:{}，开始登录服务端", port);
                    }
                });
                this.channel = future.channel();
            }
        } catch (Exception e) {
            log.error("连接客户端失败,error：" + e);
            connectFlag = false;
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        doConnect(new Bootstrap(), loop);
    }

    public void writeAndFlushs(String content) throws UnsupportedEncodingException, InterruptedException {
        if (content.length() == 0) {
            return;
        }

        String[] strings = content.split(";|,|；|，|。|、");
//        String[] strings = content.split("，");
//        String last = content;
//        List<String> strings = getStrList(content, 10);
        for (String str : strings) {
            toWriteAndFlushs(str);
            Thread.sleep(500);
        }

//        toWriteAndFlushs(content);
    }

    public void toWriteAndFlushs(String content) throws UnsupportedEncodingException {
//        FE 5C 4B 89  固定
//        28 00 00 00 ( x+30 + 5B)
//        68 03 00 00 00  固定
//        15 00 00 00 （x+11 + 5B）长度
//        00 00 12 99 73  固定
//        FD 00           固定
//        0A  长度 + 5 x B
//        01 00 固定
//        5B 6D 35 32 5D 固定
//        BB B6 D3 AD B9 E2 C1 D9  （欢迎光临）
//        3E 00 00 FF FF 固定

        if (content.length() == 0) {
            return;
        }

        byte[] bytes = content.getBytes("utf-8");
        byte[] bytes2 = new String(bytes, "utf-8").getBytes("gbk");
        String outString = byte2Hex(bytes2).toUpperCase();

        int length = bytes2.length + 2 + 5 + 4;
        String endString = new String();
//        endString += "FE5C4B89";
//        endString += Integer.toHexString(length + 30) + "000000";
//        endString += "6803000000";
//        endString += Integer.toHexString(length + 10) + "000000";
//        endString += "0000129973";
        endString += "FD00";
        String hs = Integer.toHexString(length).toUpperCase();
        if (hs.length() < 2) {
            hs = "0" + hs;
        }
        endString += hs;
        endString += "0100";
        endString += "5B6D35325D5B73395D";//31-39控制语速
        endString += outString;
//        endString += "3E0000FFFF";
        ByteBuf buf = Unpooled.copiedBuffer(endString, CharsetUtil.US_ASCII);
        this.channel.writeAndFlush(buf);
    }

    private String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
