
package com.nhfc99.template.component.SocketServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;

import java.nio.charset.Charset;

/**
 * soket监听服务
 * 
 * @author xu
 */
public class NettyServer implements Runnable {

    /** 异常输出 */
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);

    /**
     * soket监听
     */
    public static void soketListener() {
    	LOGGER.info("================5.NettyServer开始启动========================");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        int port = 8890;
        try {
        	LOGGER.info("================7.1 NettyServer 端口为：" + port + "========================");
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)  //绑定线程池
                .channel(NioServerSocketChannel.class)  // 指定使用的channel
                .childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(64, 65535, 65535))
                .childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    LOGGER.info("================7.2 报告，有个socket客户端链接到本服务器, IP为：" + ch.localAddress().getHostName() + ", Port为：" + ch.localAddress().getPort() + "========================");
                    //编码格式
//                    ch.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
//                    ch.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
                    ch.pipeline().addLast(new ServerHandler()); // 客户端触发操作
                }
            });
            LOGGER.info("================8.NettyServer 启动中.....========================");
            ChannelFuture channelFuture = bootstrap.bind(port).sync(); // 服务器异步创建绑定
            LOGGER.info("================9.NettyServer 启动完毕！！========================");
            channelFuture.channel().closeFuture().sync(); // 关闭服务器通道
            LOGGER.info("================41.NettyServer 关闭服务器通道！！========================");
        } catch (Exception e) {
        	LOGGER.error("================4.1 NettyServer 端口为：" + port + " 启动出现异常， 异常内容为：" + e.getMessage() + "========================");
        } finally {
        	LOGGER.error("================4.2 NettyServer 服务关闭========================");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * @see Runnable#run()
     */
    @Override
    public void run() {
//        LOGGER.info("================4.多线程启动Netty Server========================");
//        NettyServer.soketListener();
    }

}
