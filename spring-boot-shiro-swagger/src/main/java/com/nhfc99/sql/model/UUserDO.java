package com.nhfc99.sql.model;

import java.io.Serializable;	
import java.util.Date;
import java.util.List;

public class UUserDO implements Serializable {
	private Long id;

	private String nickname;

	private String email;

	private String pswd;

	private Date create_time;

	private Date last_login_time;

	private Long status;

	private List<String> roleStrlist;
	
	public List<String> getRoleStrlist() {
		return roleStrlist;
	}

	public void setRoleStrlist(List<String> roleStrlist) {
		this.roleStrlist = roleStrlist;
	}

	public List<String> getPerminsStrlist() {
		return perminsStrlist;
	}

	public void setPerminsStrlist(List<String> perminsStrlist) {
		this.perminsStrlist = perminsStrlist;
	}

	private List<String> perminsStrlist;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
}