package com.nhfc99.template.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TestingbaseDomain implements Serializable {

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 名称
     */
    private String name;

    /**
     * 父id
     */
    private Long parentid;

    /**
     * 描述
     */
    private String explains;

    /**
     * testingbase
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-07-09
     */
    public TestingbaseDomain(Long id, String title, String name, Long parentid, String explains) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.parentid = parentid;
        this.explains = explains;
    }

    /**
     *
     * @mbggenerated 2020-07-09
     */
    public TestingbaseDomain() {
        super();
    }

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父id
     * @return parentid 父id
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * 父id
     * @param parentid 父id
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * 描述
     * @return explain 描述
     */
    public String getExplains() {
        return explains;
    }

    /**
     * 描述
     * @param explain 描述
     */
    public void setExplains(String explain) {
        this.explains = explain == null ? null : explain.trim();
    }
}