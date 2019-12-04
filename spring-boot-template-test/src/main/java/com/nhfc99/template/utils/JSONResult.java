package com.nhfc99.template.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JSONResult {

    static int code_SUCCESS = 0;
    static int code_FAILED = 1;

    int code;
    String msg;
    @JsonIgnore
    Object data;

    public static JSONResult success(Object data) {
        return success(data, "成功");
    }

    public static JSONResult success(Object data, String msg) {
        return new JSONResult(code_SUCCESS, msg, data);
    }

    public static JSONResult failed() {
        return new JSONResult(code_FAILED, "空数据", null);
    }

    public static JSONResult failed(String msg) {
        return new JSONResult(code_FAILED, msg, null);
    }

    public static JSONResult result(int code, String msg, Object data) {
        return new JSONResult(code, msg, data);
    }

    public static JSONResult result(int code, String msg) {
        return new JSONResult(code, msg);
    }

    public JSONResult(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult() {
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
