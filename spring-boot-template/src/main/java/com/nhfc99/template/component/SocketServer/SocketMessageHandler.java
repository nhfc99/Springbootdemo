//package com.nhfc99.template.component.SocketServer;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.nhfc99.template.component.BeanContext.BeanContext;
//import com.nhfc99.template.component.redis.RedisUtil;
//import com.nhfc99.template.config.VRDeviceType;
//import io.netty.channel.ChannelHandlerContext;
//import lombok.extern.slf4j.Slf4j;
//
//import java.net.InetSocketAddress;
//import java.util.*;
//
//@Slf4j
//public class SocketMessageHandler {
//
//    Timer timer = new Timer(true);
//    TimerTask timerTask = null;
//
//    //redis
//    RedisUtil redisUtil() {
//        return BeanContext.getApplicationContext().getBean(RedisUtil.class);
//    }
//
//    //保存name和CTX的Map
//    Map<String, ChannelHandlerContext> contentMap = new HashMap<>();
//    Map<ChannelHandlerContext, String> contentCMap = new HashMap<>();
//    public static String splists = "---";
//
//    public String getIp(ChannelHandlerContext ctx) {
//        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
//        String clientIP = insocket.getAddress().getHostAddress();
//        return clientIP;
//    }
//
//    public void addMap(String name, ChannelHandlerContext ctx) {
//        delMap(name, ctx);
//        contentMap.put(name, ctx);
//        contentCMap.put(ctx, name);
//    }
//
//    public void delMap(String name, ChannelHandlerContext ctx) {
//        if (name != null) {
//            ChannelHandlerContext thectx = contentMap.get(name);
//            contentMap.remove(name);
//            contentCMap.remove(thectx);
//        }
//
//        if (ctx != null) {
//            name = contentCMap.get(ctx);
//            contentMap.remove(name);
//            contentCMap.remove(ctx);
//        }
//    }
//
//    public void delCtx(ChannelHandlerContext ctx) {
//        if (ctx != null) {
//            String name = contentCMap.get(ctx);
//            delMap(name, ctx);
//        }
//    }
//
//    String getNameByCTX(ChannelHandlerContext ctx) {
//        return contentCMap.get(ctx);
//    }
//
//    public void addLast(String lastString, ChannelHandlerContext ctx) {
//        if (lastString.length() == 0 || ctx == null) {
//            return;
//        }
//        delLast(ctx);
//        String name = getNameByCTX(ctx);
//        if (name != null) {
//            redisUtil().set(name, lastString, 2);
//        }
//    }
//
//    public void delLast(ChannelHandlerContext ctx) {
//        if (ctx == null) {
//            return;
//        }
//        String name = getNameByCTX(ctx);
//        if (name != null) {
//            redisUtil().del(name);
//        }
//    }
//
//    public String getLastString(ChannelHandlerContext ctx) {
//        if (ctx == null) {
//            return null;
//        }
//        String object = null;
//        String name = getNameByCTX(ctx);
//        if (name != null) {
//            object = (String) redisUtil().get(name);
//        }
//        return object;
//    }
//
//    public ChannelHandlerContext getChannelHandlerContext(String name) {
//        return contentMap.get(name);
//    }
//
//    public Map<String, ChannelHandlerContext> getAll() {
//        return contentMap;
//    }
//
//    public ArrayList<SocketReceiveModel> getSocketReceiveModel(ChannelHandlerContext ctx, String body) {
//        String oldBody = body;
//        //从redis中获取之前的lastString
//        String lastString = getLastString(ctx);
//        //将之前的遗留下的拼接到头部
//        if (lastString != null) {
//            body = lastString + body;
//            lastString = null;
//            delLast(ctx);
//        }
//
//        //判断是否以splists结束，如果是以splists结尾，那么可以直接进行
//        String[] subString = null;
//        ArrayList<String> arrayList = null;
//        if (!body.endsWith(splists)) {
//            arrayList = new ArrayList<String>(Arrays.asList(body.split(splists)));
//            lastString = arrayList.get(arrayList.size() - 1);
//            //将lastString保存至redis中
//            addLast(lastString, ctx);
//            arrayList.remove(arrayList.size() - 1);
//            //记录每个分解之前的字符串
//            subString = arrayList.toArray(new String[arrayList.size()]);
//            body = String.join(",", subString);
//        } else {
//            body = body.substring(0, body.length() - splists.length());//如果是最后的标识为splists，直接干掉最后的就可以了
//            //记录每个分解之前的字符串
//            subString = body.split(splists);
//            body = body.replaceAll(splists, ",");
//        }
//        body = "[" + body + "]";
//        JSONArray jsonArray = null;
//        try {
//            jsonArray = JSONArray.parseArray(body);
//        } catch (Exception e) {
//            try {
//                body = "[" + oldBody + "]";
//                jsonArray = JSONArray.parseArray(body);
//            } catch (Exception ex) {
//                log.error("解析字符串最后失败");
//            }
//        }
//        if (jsonArray == null) {
//            return null;
//        }
//
////      格式:{"code":0,"message":"","content":{"type":"","from":"","to":"","data":""}}
//        ArrayList<SocketReceiveModel> socketReceiveModelArrayList = new ArrayList<>();
//        Object[] list = jsonArray.toArray();
//        for (int i = 0; i < list.length; i++) {
//            Object jsonobject = list[i];
//            JSONObject object = (JSONObject) jsonobject;
//            SocketReceiveModel socketReceiveModel = new SocketReceiveModel();
//            socketReceiveModel.setOutstring(subString[i]);
//            if (object.containsKey("code")) {
//                socketReceiveModel.setCode(object.getInteger("code"));
//            }
//
//            if (object.containsKey("message")) {
//                socketReceiveModel.setMessage(object.getString("message"));
//            }
//
//            if (object.containsKey("content")) {
//                JSONObject contentObject = (JSONObject) object.get("content");
//                if (contentObject.containsKey("type")) {
//                    socketReceiveModel.setType(contentObject.getString("type"));
//                }
//
//                if (contentObject.containsKey("from")) {
//                    socketReceiveModel.setFrom(contentObject.getString("from"));
//                }
//
//                if (contentObject.containsKey("to")) {
//                    socketReceiveModel.setTo(contentObject.getString("to"));
//                }
//
//                if (contentObject.containsKey("data")) {
//                    socketReceiveModel.setData(contentObject.getString("data"));
//                }
//            }
//            socketReceiveModelArrayList.add(socketReceiveModel);
//        }
//        return socketReceiveModelArrayList;
//    }
//
//    /**
//     * 测试是否是心跳
//     *
//     * @return
//     */
//    public boolean checkHart(ChannelHandlerContext ctx, String body) {
//        if (body.compareTo(VRDeviceType.kVoicehart) == 0) {
//            addMap(VRDeviceType.kVoice, ctx);
//            log.info("收到语音心跳!");
//
//            //动第一次收到心跳开始，如果操作40s的时候还没有收到心跳那么就将服务干掉
//            checkVoiceState(ctx);
//
//            return true;
//        }
//        return false;
//    }
//
//    public void checkVoiceState(ChannelHandlerContext ctx) {
//        if (timerTask != null) {
//            timerTask.cancel();
//            timerTask = null;
//            log.info("timerTask cancel success");
//        }
//
//        timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                delCtx(ctx);
//                log.info("Socket - 语音超时!");
//            }
//        };
//        timer.schedule(timerTask, 70000);//70秒之后进行执行
//    }
//}
