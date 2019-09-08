package com.nhfc99.duty.model;

import java.io.Serializable;

public class RestdayDO implements Serializable {
    private Integer id;

    private String h_date;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getH_date() {
        return h_date;
    }

    public void setH_date(String h_date) {
        this.h_date = h_date;
    }
}