//package com.nhfc99.template.component.SocketClient;
//
//import com.nhfc99.template.component.BeanContext.BeanContext;
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.EventLoop;
//import io.netty.channel.SimpleChannelInboundHandler;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class ClientHandler extends SimpleChannelInboundHandler<Object> {
//    SocketClient socketClient() {
//        return BeanContext.getApplicationContext().getBean(SocketClient.class);
//    }
//
//    //处理服务端返回的数据
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, Object response) throws Exception {
//        System.out.println("接受到server响应数据: " + response.toString());
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        ctx.close();
//    }
//
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        log.info("与服务器连接断开，尝试重新连接...");
//        socketClient().retryConnectFlag = true;
//        final EventLoop eventLoop = ctx.channel().eventLoop();
//        // 立即重连
//        socketClient().doConnect(new Bootstrap(), eventLoop);
//        super.channelInactive(ctx);
//    }
//}
