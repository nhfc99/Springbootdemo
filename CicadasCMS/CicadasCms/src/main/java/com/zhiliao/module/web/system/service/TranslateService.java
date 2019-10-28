package com.zhiliao.module.web.system.service;

import com.alibaba.fastjson.JSONObject;

public interface TranslateService {

    String translateToString(String text);

    JSONObject translate(String text);

}
