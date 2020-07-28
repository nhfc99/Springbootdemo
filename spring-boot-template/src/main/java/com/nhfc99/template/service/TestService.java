package com.nhfc99.template.service;

import com.nhfc99.template.config.VRDeviceType;
import com.nhfc99.template.pojo.SocketReceiveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TestService {
    @Autowired
    AllSocketService allSocketService;

    public void sendMessage(String message) throws IOException, InterruptedException {
        SocketReceiveModel socketReceiveModel = new SocketReceiveModel();
        socketReceiveModel.setData(message);
        socketReceiveModel.setTo(VRDeviceType.kPlay);
        socketReceiveModel.setFrom(VRDeviceType.kSocketServer);
        socketReceiveModel.setType(VRDeviceType.kPlay);
        allSocketService.sendMessage(VRDeviceType.kPlay, message, socketReceiveModel);
    }
}
