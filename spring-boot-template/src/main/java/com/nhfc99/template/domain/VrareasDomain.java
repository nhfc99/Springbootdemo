package com.nhfc99.template.domain;

import java.io.Serializable;

public class VrareasDomain implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父id
     */
    private Long parentid;

    /**
     * vrareas
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrareasDomain(Long id, String name, Long parentid) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrareasDomain() {
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
}