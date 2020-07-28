package com.nhfc99.template.domain;

import java.io.Serializable;

public class VrhonoursDomain implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String explains;

    /**
     * 图片
     */
    private String img;

    /**
     * vrhonours
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrhonoursDomain(Long id, String title, String explain, String img) {
        this.id = id;
        this.title = title;
        this.explains = explain;
        this.img = img;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrhonoursDomain() {
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

    /**
     * 图片
     * @return img 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 图片
     * @param img 图片
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}