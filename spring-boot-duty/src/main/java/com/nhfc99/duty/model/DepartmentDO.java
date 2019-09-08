package com.nhfc99.duty.model;

import java.io.Serializable;

public class DepartmentDO implements Serializable {
    private Integer id;

    private String d_name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }
}