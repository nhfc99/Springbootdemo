package com.nhfc99.template.pojo;

import lombok.Data;

import java.io.Serializable;

//{"code":0,"message":"你才","content":{"from":"vrtm","to":"screentm","type":"10001", "data":"ceshi"}}

@Data
public class SocketReceiveModel implements Serializable {
    private int code;
    private String message;
    private String type;
    private String from;
    private String to;
    private String data;
    private String outstring;
}
