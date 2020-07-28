package com.nhfc99.template.domain;

import java.io.Serializable;

public class VrtestcenterbaseinfoDomain implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 简介
     */
    private String description;

    /**
     * logo路径
     */
    private String logo;

    /**
     * 首屏播放的视频列表，使用分号进行分割
     */
    private String videos;

    /**
     * vrtestcenterbaseinfo
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrtestcenterbaseinfoDomain(Long id, String name, String description, String logo, String videos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.videos = videos;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrtestcenterbaseinfoDomain() {
        super();
    }

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
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
     * 简介
     * @return description 简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 简介
     * @param description 简介
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * logo路径
     * @return logo logo路径
     */
    public String getLogo() {
        return logo;
    }

    /**
     * logo路径
     * @param logo logo路径
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 首屏播放的视频列表，使用分号进行分割
     * @return videos 首屏播放的视频列表，使用分号进行分割
     */
    public String getVideos() {
        return videos;
    }

    /**
     * 首屏播放的视频列表，使用分号进行分割
     * @param videos 首屏播放的视频列表，使用分号进行分割
     */
    public void setVideos(String videos) {
        this.videos = videos == null ? null : videos.trim();
    }
}