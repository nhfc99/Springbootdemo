package com.nhfc99.template.service;

import com.nhfc99.template.component.SocketClient.SocketClient;
import com.nhfc99.template.component.SocketServer.SocketMessageHandler;
import com.nhfc99.template.config.VRDeviceType;
import com.nhfc99.template.pojo.SocketReceiveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class AllSocketService {
    @Autowired
    SocketService socketService;
    @Autowired
    WebSocketService webSocketService;
    @Autowired
    SocketClient socketClient;

    public void sendMessage(String to, String message, SocketReceiveModel socketReceiveModel) throws IOException, InterruptedException {
        if (to.compareTo(VRDeviceType.kPlay) == 0) {
            socketClient.writeAndFlushs(socketReceiveModel.getData());
        } else {
            socketService.sendMessage(to, message + SocketMessageHandler.splists);
            webSocketService.sendMessage(to, message);
        }
    }

    /**
     * 给所有人发送消息 -- 用于语音操作
     *
     * @param message
     * @throws IOException
     */
    public void sendMessageToAll(String message) throws IOException {
        socketService.sendMessageToAll(message + SocketMessageHandler.splists);
        webSocketService.sendMessageToAll(message);
    }
}
