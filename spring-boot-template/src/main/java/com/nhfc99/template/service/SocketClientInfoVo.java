package com.nhfc99.template.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

@Data
public class SocketClientInfoVo {
    private ArrayList<String> sockets;
    private Map<String, String> socketsMap;
    private ArrayList<String> websockets;
}
