package com.nhfc99.duty.model;

import java.io.Serializable;

public class UserDO implements Serializable {
    private Integer id;

    private String u_name;

    private String u_phone;

    private Integer u_dpid;

    private Integer u_pid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public Integer getU_dpid() {
        return u_dpid;
    }

    public void setU_dpid(Integer u_dpid) {
        this.u_dpid = u_dpid;
    }

    public Integer getU_pid() {
        return u_pid;
    }

    public void setU_pid(Integer u_pid) {
        this.u_pid = u_pid;
    }
}