package com.nhfc99.template.domain;

import java.io.Serializable;

public class User extends UserKey implements Serializable {
    private String u_username;

    private String u_passwd;

    private static final long serialVersionUID = 1L;

    public User(Integer id, String u_id, String u_username, String u_passwd) {
        super(id, u_id);
        this.u_username = u_username;
        this.u_passwd = u_passwd;
    }

    public User() {
        super();
    }

    public String getU_username() {
        return u_username;
    }

    public void setU_username(String u_username) {
        this.u_username = u_username == null ? null : u_username.trim();
    }

    public String getU_passwd() {
        return u_passwd;
    }

    public void setU_passwd(String u_passwd) {
        this.u_passwd = u_passwd == null ? null : u_passwd.trim();
    }
}