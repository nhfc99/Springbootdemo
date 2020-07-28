package com.nhfc99.template.service;

import com.nhfc99.template.component.websocket.WebSocketMessageHandler;
import com.nhfc99.template.component.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class WebSocketService {

    WebSocketMessageHandler webSocketMessageHandler = WebSocketServer.webSocketMessageHandler;

    /**
     * 给某个人发送消息
     * @param to
     * @param message
     * @throws IOException
     */
    public void sendMessage(String to, String message) throws IOException {
        WebSocketServer webSocketServer = webSocketMessageHandler.getWebSocketServer(to);
        if (webSocketServer != null) {
            webSocketServer.sendMessage(message);
        }
    }

    /**
     * 给所有人发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessageToAll(String message) throws IOException {
        ConcurrentHashMap<String, WebSocketServer> all = webSocketMessageHandler.getAll();
        for (WebSocketServer webSocketServer : all.values()) {
            webSocketServer.sendMessage(message);
        }
    }
}
