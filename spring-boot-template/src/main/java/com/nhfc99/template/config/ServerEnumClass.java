package com.nhfc99.template.config;

public enum ServerEnumClass {
    km_NotFound(0),                             //未发现
    km_ScreenImage(10000),                      //大屏截屏数据
    km_OpenScreen(10001),                       //打开大屏
    km_CloseScreen(10002),                      //关闭大屏
    km_ScreenMouseMove(10003),                  //大屏鼠标移动事件
    km_ScreenMouseClick(10004),                 //大屏鼠标点击事件
    km_OpenVR(10006),                           //打开VR
    km_CloseVR(10007),                          //关闭VR
    km_RegisterSocketClient(10008);             //注册Socket客户端

    private int value;

    private ServerEnumClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest() {
        return false;
    }
}