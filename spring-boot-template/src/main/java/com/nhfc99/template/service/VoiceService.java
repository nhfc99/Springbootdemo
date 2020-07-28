package com.nhfc99.template.service;

import com.alibaba.fastjson.JSON;
import com.nhfc99.template.component.SocketServer.ServerHandler;
import com.nhfc99.template.component.SocketServer.SocketMessageHandler;
import com.nhfc99.template.config.VRDeviceType;
import com.nhfc99.template.pojo.SocketReceiveModel;
import com.nhfc99.template.vo.VoiceSystemCommandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class VoiceService {
    @Autowired
    VoicecommandService voicecommandService;

    @Autowired
    AllSocketService allSocketService;

    //所有Socket客户端
    SocketMessageHandler socketMessageHandler = ServerHandler.socketMessageHandler;

    //收到语音消息
    public void receiveVoiceMessage(String voiceMessage) {
        try{
            ArrayList<VoiceSystemCommandVo> list = voicecommandService.selectByVCommand(voiceMessage);
            if (list.size() > 0) {
                VoiceSystemCommandVo voiceSystemCommandVo = list.get(0);

                Map<String, Object> contentMap = new HashMap<>();
                contentMap.put("form", VRDeviceType.kVoice);
                contentMap.put("to", VRDeviceType.kPublish);
                contentMap.put("type", voiceSystemCommandVo.getScommand());
                String data = voiceSystemCommandVo.getData();
                if (data != null && data.length() > 0) {
                    contentMap.put("data", data);
                }

                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("code", 0);
                resultMap.put("message", "语音消息");
                resultMap.put("content", contentMap);

                allSocketService.sendMessageToAll(JSON.toJSONString(resultMap));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
