package com.nhfc99.template.domain;

import java.io.Serializable;

public class UserKey implements Serializable {
    private Integer id;

    private String u_id;

    private static final long serialVersionUID = 1L;

    public UserKey(Integer id, String u_id) {
        this.id = id;
        this.u_id = u_id;
    }

    public UserKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id == null ? null : u_id.trim();
    }
}