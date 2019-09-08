package com.nhfc99.duty.model;

import java.io.Serializable;

public class UserDO implements Serializable {
    private Integer id;

    private String u_name;

    private String u_phone;

    private Integer u_dpid;

    private Integer u_pid;
    
    private Integer u_day;
    private Integer u_night;

    public Integer getU_day() {
		return u_day;
	}

	public void setU_day(Integer u_day) {
		this.u_day = u_day;
	}

	public Integer getU_night() {
		return u_night;
	}

	public void setU_night(Integer u_night) {
		this.u_night = u_night;
	}

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