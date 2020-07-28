package com.nhfc99.template.component.websocket;

import com.nhfc99.template.component.BeanContext.BeanContext;
import com.nhfc99.template.pojo.SocketReceiveModel;
import com.nhfc99.template.service.AllSocketService;
import com.nhfc99.template.service.VoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/socket/{userId}")
@Component
@Slf4j
public class WebSocketServer {
    public static WebSocketMessageHandler webSocketMessageHandler = new WebSocketMessageHandler();

    @Autowired
    AllSocketService allSocketService;

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 接收userId
     */
    private String userId = "";

    AllSocketService allSocketService() {
        return BeanContext.getApplicationContext().getBean(AllSocketService.class);
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;

        if (webSocketMessageHandler.addWebSocketServer(userId, this)) {
            //在线数加1
            addOnlineCount();
            log.info("用户连接:" + userId + ",当前在线人数为:" + getOnlineCount());
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (webSocketMessageHandler.delWebSocketServer(userId)) {
            //从set中删除
            subOnlineCount();
            log.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("用户消息:" + userId + ",报文:" + message);

        try {
            SocketReceiveModel socketReceiveModel = webSocketMessageHandler.getSocketReceiveModel(message);
            allSocketService().sendMessage(socketReceiveModel.getTo(), socketReceiveModel.getOutstring(), socketReceiveModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}