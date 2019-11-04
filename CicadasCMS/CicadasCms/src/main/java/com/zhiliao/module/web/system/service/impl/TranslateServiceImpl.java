package com.zhiliao.module.web.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhiliao.common.utils.TranslateUtil;
import com.zhiliao.module.web.system.service.TranslateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateServiceImpl implements TranslateService {

    @Value("${youdao.translate.appKey}")
    private String appKey;

    @Value("${youdao.translate.appSecret}")
    private String appSecret;

    @Value("${youdao.translate.url}")
    private String url;


    @Override
    public String translateToString(String text) {
        JSONObject result = new JSONObject();
        result.put("success","error");
        if(StringUtils.isEmpty(text)){
            result.put("message","翻译文本不能为空！");
            return result.toJSONString();
        }
        try {
            String salt = String.valueOf(System.currentTimeMillis());
            String from = "zh-CHS";
            String to = "EN";
            String sign = TranslateUtil.md5(appKey + text + salt+ appSecret);
            Map params = new HashMap();
            params.put("q", text);
            params.put("from", from);
            params.put("to", to);
            params.put("sign", sign);
            params.put("salt", salt);
            params.put("appKey", appKey);
            JSONObject translateResult = JSONObject.parseObject(TranslateUtil.requestForHttp(url, params));
             if("0".equals(translateResult.getString("errorCode"))){
                 result.put("data",translateResult.getJSONArray("translation").get(0));
                 result.put("success","ok");
                 result.put("message","翻译成功！");
             }else {
                 result.put("message","翻译失败！");
             }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("message",e.getMessage());
        }
        return result.toJSONString();
    }

    @Override
    public JSONObject translate(String text) {
        JSONObject result = new JSONObject();
        result.put("success","error");
        if(StringUtils.isEmpty(text)){
            result.put("message","翻译文本不能为空！");
            return result;
        }
        try {
            String salt = String.valueOf(System.currentTimeMillis());
            String from = "zh-CHS";
            String to = "EN";
            String sign = TranslateUtil.md5(appKey + text + salt+ appSecret);
            Map params = new HashMap();
            params.put("q", text);
            params.put("from", from);
            params.put("to", to);
            params.put("sign", sign);
            params.put("salt", salt);
            params.put("appKey", appKey);
            JSONObject translateResult = JSONObject.parseObject(TranslateUtil.requestForHttp(url, params));
            if("0".equals(translateResult.getString("errorCode"))){
                result.put("data",translateResult.getJSONArray("translation").get(0));
                result.put("success","ok");
                result.put("message","翻译成功！");
            }else {
                result.put("message","翻译失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("message",e.getMessage());
        }
        return result;
    }
}
