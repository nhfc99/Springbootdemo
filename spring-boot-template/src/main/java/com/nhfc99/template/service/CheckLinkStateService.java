package com.nhfc99.template.service;

import com.nhfc99.template.component.SocketServer.ServerHandler;
import com.nhfc99.template.component.SocketServer.SocketMessageHandler;
import com.nhfc99.template.component.websocket.WebSocketMessageHandler;
import com.nhfc99.template.component.websocket.WebSocketServer;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class CheckLinkStateService {
    @Autowired
    ServerHandler serverHandler;

    public static WebSocketMessageHandler webSocketMessageHandler = new WebSocketMessageHandler();
    public static SocketMessageHandler socketMessageHandler = new SocketMessageHandler();

    /**
     * 获取所有连接socket客户端
     * @return
     */
    public Map<String, String> getSocketInfo() {
        Map<String, ChannelHandlerContext> map = socketMessageHandler.getAll();
        Map<String, String> stringStringMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        for (String key:arrayList) {
            stringStringMap.put(key, socketMessageHandler.getIp(map.get(key)));
        }
        return stringStringMap;
    }

    public ArrayList<String> getSocketInfoName() {
        Map<String, ChannelHandlerContext> map = serverHandler.socketMessageHandler.getAll();
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        return arrayList;
    }

    /**
     * 获取所有的websocket客户端
     * @return
     */
    public ArrayList<String> webSocketInfo() {
        ConcurrentHashMap<String, WebSocketServer> hashMap = webSocketMessageHandler.getAll();
        Map<String, String> stringStringMap = new HashMap<>();
        return new ArrayList<>(hashMap.keySet());
    }
}
