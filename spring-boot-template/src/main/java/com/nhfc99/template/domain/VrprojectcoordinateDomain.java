package com.nhfc99.template.domain;

import java.io.Serializable;

public class VrprojectcoordinateDomain implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 项目id
     */
    private String projectinfoid;

    /**
     * x位置
     */
    private Integer coorx;

    /**
     * y位置
     */
    private Integer coory;

    /**
     * vrprojectcoordinate
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-30
     */
    public VrprojectcoordinateDomain(Long id, String projectinfoid, Integer coorx, Integer coory) {
        this.id = id;
        this.projectinfoid = projectinfoid;
        this.coorx = coorx;
        this.coory = coory;
    }

    /**
     *
     * @mbggenerated 2020-05-30
     */
    public VrprojectcoordinateDomain() {
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
     * 项目id
     * @return projectinfoid 项目id
     */
    public String getProjectinfoid() {
        return projectinfoid;
    }

    /**
     * 项目id
     * @param projectinfoid 项目id
     */
    public void setProjectinfoid(String projectinfoid) {
        this.projectinfoid = projectinfoid == null ? null : projectinfoid.trim();
    }

    /**
     * x位置
     * @return coorx x位置
     */
    public Integer getCoorx() {
        return coorx;
    }

    /**
     * x位置
     * @param coorx x位置
     */
    public void setCoorx(Integer coorx) {
        this.coorx = coorx;
    }

    /**
     * y位置
     * @return coory y位置
     */
    public Integer getCoory() {
        return coory;
    }

    /**
     * y位置
     * @param coory y位置
     */
    public void setCoory(Integer coory) {
        this.coory = coory;
    }
}