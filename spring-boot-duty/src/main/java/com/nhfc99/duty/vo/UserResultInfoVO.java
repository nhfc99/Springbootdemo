package com.nhfc99.duty.vo;

public class UserResultInfoVO {
    private String u_name;
    private String u_dpname;
    private String u_pname;

    private String u_phone;

    private Integer u_day;
    private Integer u_night;

    private Integer allDays;

    public String getU_dpname() {
        return u_dpname;
    }

    public void setU_dpname(String u_dpname) {
        this.u_dpname = u_dpname;
    }

    public String getU_pname() {
        return u_pname;
    }

    public void setU_pname(String u_pname) {
        this.u_pname = u_pname;
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

    public Integer getAllDays() {
        return allDays;
    }

    public void setAllDays(Integer allDays) {
        this.allDays = allDays;
    }
}
