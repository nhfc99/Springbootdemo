package com.nhfc99.duty.vo;

public class ResultVO {
	private String date; // 日期
	private String username; // 姓名
	private String telphone; // 电话
	private String sduty; // 值班类型：白班还是夜班
	private String department; // 院系名称
	private String position; // 职位

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getSduty() {
		return sduty;
	}

	public void setSduty(String sduty) {
		this.sduty = sduty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
