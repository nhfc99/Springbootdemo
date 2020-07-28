package com.nhfc99.template.component.SocketServer;

import com.nhfc99.template.component.BeanContext.BeanContext;
import com.nhfc99.template.component.redis.RedisUtil;
import com.nhfc99.template.config.ServerEnumClass;
import com.nhfc99.template.config.VRDeviceType;
import com.nhfc99.template.domain.DeviceipinfoDomain;
import com.nhfc99.template.pojo.SocketReceiveModel;
import com.nhfc99.template.service.AllSocketService;
import com.nhfc99.template.service.DeviceipinfoService;
import com.nhfc99.template.service.VoiceService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 客户端触发操作
 */
@Service
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {
    public static SocketMessageHandler socketMessageHandler = new SocketMessageHandler();

    //redis
    RedisUtil redisUtil() {
        return BeanContext.getApplicationContext().getBean(RedisUtil.class);
    }

    //socket
    AllSocketService allSocketService() {
        return BeanContext.getApplicationContext().getBean(AllSocketService.class);
    }

    //voice
    VoiceService voiceService() {
        return BeanContext.getApplicationContext().getBean(VoiceService.class);
    }

    //设备ip信息
    DeviceipinfoService deviceipinfoService() {
        return BeanContext.getApplicationContext().getBean(DeviceipinfoService.class);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerHandler.class);

    /**
     * channelAction
     * channel 通道 action 活跃的
     * 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("================13. 通过活跃中....========================");
    }

    /**
     * channelInactive
     * channel 通道 Inactive 不活跃的
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     *
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        LOGGER.warn("--------Netty Disconnect Client IP is :" + ctx.channel().id().asShortText() + " "
                + ctx.channel().remoteAddress() + "--------");
        LOGGER.info("================9.客户端主动断开服务端的链接========================");
//        String clientIP = socketMessageHandler.getIp(ctx);
//        socketMessageHandler.delMap(clientIP, null);
        socketMessageHandler.delCtx(ctx);
        ctx.close();
    }

    /**
     * 功能：读取服务器发送过来的信息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LOGGER.info("================14. 通道读取服务器发送过来的信息========================");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, CharsetUtil.US_ASCII);
        buf.release();
        handleMessage(ctx, body);
    }

    private void handleMessage(ChannelHandlerContext ctx, String body) {
        LOGGER.info("================15. 业务逻辑处理开始========================消息:" + body);

        try {//防止报错断开连接
            //判断语音心跳机制 -- 如果是心跳的时候将返回不再进行操作
            if (socketMessageHandler.checkHart(ctx, body)) {
                return;
            }

            //处理语音
            ChannelHandlerContext voiceCtx = socketMessageHandler.getChannelHandlerContext(VRDeviceType.kVoice);
            if (ctx == voiceCtx) {
                log.info("收到语音消息：" + body);
                //回复语音收到
                ByteBuf buf = Unpooled.copiedBuffer("2000" + body, CharsetUtil.US_ASCII);
                ctx.writeAndFlush(buf);
                //解析语音
                voiceService().receiveVoiceMessage(body);
            } else {//处理其他端设备
                log.info("收到普通消息:" + body);
                ArrayList<SocketReceiveModel> socketReceiveModelArrayList = socketMessageHandler.getSocketReceiveModel(ctx, body);
                for (SocketReceiveModel socketReceiveModel : socketReceiveModelArrayList) {
                    //处理发给服务端Server Socket
                    if (socketReceiveModel != null) {
                        //接收发给服务端的数据
                        if (socketReceiveModel.getTo().compareTo(VRDeviceType.kSocketServer) == 0) {
                            dealSocketServer(ctx, socketReceiveModel);
                        } else {//自动转向其他端
                            String out = socketReceiveModel.getOutstring();
                            dealOtherMessage(socketReceiveModel, out);
                            LOGGER.info("================18. 返回给Socket请求客户端的处理结果为：" + socketReceiveModel.getOutstring() + "========================");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("================17. Netty读取信息已经完成啦！！========================");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("--------Netty Exception ExceptionCaught :" + ctx.channel().id().asShortText() + " "
                + cause.getMessage() + "=======================", cause);
        ctx.close();
    }

    /**
     * 处理服务端数据
     *
     * @param socketReceiveModel
     */
    void dealSocketServer(ChannelHandlerContext ctx, SocketReceiveModel socketReceiveModel) {
        int type = ServerEnumClass.km_RegisterSocketClient.getValue();
        String types = String.valueOf(type);
        if (socketReceiveModel.getType().compareTo(types) == 0) {//注册Socket CSClient和Socket CSServer
            socketMessageHandler.addMap(socketReceiveModel.getFrom(), ctx);
        }

        log.info("现在有的socket clients:");
        for (String name : socketMessageHandler.contentMap.keySet()) {
            log.info("name = " + name + "," +
                    "ctx = " + socketMessageHandler.contentMap.get(name) +
                    "ip = " + socketMessageHandler.getIp(ctx));
        }
    }

    /**
     * 处理业务数据
     *
     * @param socketReceiveModel
     * @param body
     */
    void dealOtherMessage(SocketReceiveModel socketReceiveModel, String body) throws IOException, InterruptedException {
        String to = socketReceiveModel.getTo();
        log.info("dealOtherMessage:" + to);
        if (to != null) {
            allSocketService().sendMessage(to, body, socketReceiveModel);
        }
    }
}
