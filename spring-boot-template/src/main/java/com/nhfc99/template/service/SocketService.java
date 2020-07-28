package com.nhfc99.template.service;

import com.nhfc99.template.component.SocketServer.ServerHandler;
import com.nhfc99.template.component.SocketServer.SocketMessageHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class SocketService {

    public static SocketMessageHandler socketMessageHandler = ServerHandler.socketMessageHandler;

    /**
     * 给某个人发送消息
     *
     * @param to
     * @param message
     * @throws IOException
     */
    public void sendMessage(String to, String message) throws IOException {
        ChannelHandlerContext ctx = socketMessageHandler.getChannelHandlerContext(to);
        if (ctx != null) {
            ByteBuf btf = Unpooled.copiedBuffer(message, CharsetUtil.UTF_8);
            ctx.writeAndFlush(btf);
        }
    }

    /**
     * 给所有人发送消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessageToAll(String message) throws IOException {
        Map<String, ChannelHandlerContext> all = socketMessageHandler.getAll();
        for (ChannelHandlerContext ctx : all.values()) {
            ByteBuf btf = Unpooled.copiedBuffer(message, CharsetUtil.UTF_8);
            ctx.writeAndFlush(btf);
        }
    }
}
