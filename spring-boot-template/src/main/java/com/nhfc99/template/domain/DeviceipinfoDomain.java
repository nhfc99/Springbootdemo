package com.nhfc99.template.domain;

import java.io.Serializable;

public class DeviceipinfoDomain implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 端口号
     */
    private String port;

    /**
     * deviceipinfo
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-06-13
     */
    public DeviceipinfoDomain(Integer id, String name, String ip, String port) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.port = port;
    }

    /**
     *
     * @mbggenerated 2020-06-13
     */
    public DeviceipinfoDomain() {
        super();
    }

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 设备名称
     * @return name 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * ip地址
     * @return ip ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip地址
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port)  {
        this.port = port == null ? null : port.trim();
    }
}