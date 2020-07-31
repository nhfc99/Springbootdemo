//package com.nhfc99.template.component.websocket;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Slf4j
//public class WebSocketMessageHandler {
//    /**
//     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//     */
//    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
//
//    public ConcurrentHashMap<String, WebSocketServer> getAll() {
//        return webSocketMap;
//    }
//
//    public WebSocketServer getWebSocketServer(String key) {
//        return webSocketMap.get(key);
//    }
//
//    /**
//     * 添加用户
//     *
//     * @param key
//     * @param webSocketServer
//     * @return
//     */
//    public boolean addWebSocketServer(String key, WebSocketServer webSocketServer) {
//        if (key == null || key.length() == 0 || webSocketServer == null) {
//            return false;
//        }
//        if (webSocketMap.containsKey(key)) {
//            webSocketMap.remove(key);
//            webSocketMap.put(key, webSocketServer);
//        } else {
//            webSocketMap.put(key, webSocketServer);
//        }
//        return true;
//    }
//
//    /**
//     * 删除用户
//     *
//     * @param key
//     * @return
//     */
//    public boolean delWebSocketServer(String key) {
//        if (key == null || key.length() == 0) {
//            return false;
//        }
//        if (webSocketMap.containsKey(key)) {
//            webSocketMap.remove(key);
//        }
//        return true;
//    }
//
//    /**
//     * 解析数据
//     *
//     * @param body
//     * @return
//     */
//    public SocketReceiveModel getSocketReceiveModel(String body) {
//        JSONObject object = JSONObject.parseObject(body);
//        SocketReceiveModel socketReceiveModel = new SocketReceiveModel();
//        socketReceiveModel.setOutstring(body);
//        if (object.containsKey("code")) {
//            socketReceiveModel.setCode(object.getInteger("code"));
//        }
//
//        if (object.containsKey("message")) {
//            socketReceiveModel.setMessage(object.getString("message"));
//        }
//
//        if (object.containsKey("content")) {
//            JSONObject contentObject = (JSONObject) object.get("content");
//            if (contentObject.containsKey("type")) {
//                socketReceiveModel.setType(contentObject.getString("type"));
//            }
//
//            if (contentObject.containsKey("from")) {
//                socketReceiveModel.setFrom(contentObject.getString("from"));
//            }
//
//            if (contentObject.containsKey("to")) {
//                socketReceiveModel.setTo(contentObject.getString("to"));
//            }
//
//            if (contentObject.containsKey("data")) {
//                socketReceiveModel.setData(contentObject.getString("data"));
//            }
//        }
//        return socketReceiveModel;
//    }
//}
