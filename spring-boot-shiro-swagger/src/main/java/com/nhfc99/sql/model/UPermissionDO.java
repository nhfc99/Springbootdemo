package com.nhfc99.sql.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户权限模型实体")
public class UPermissionDO implements Serializable {
	@ApiModelProperty(name = "id", value = "主键", hidden = false)
	private Long id;
	@ApiModelProperty(name = "url", value = "url地址内容")
	private String url;
	@ApiModelProperty(name = "name", value = "权限名称")
	private String name;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}