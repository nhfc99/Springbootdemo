package com.nhfc99.template.domain;

import java.io.Serializable;

public class VrstaffDomain implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 职级（0-4
     */
    private Integer level;

    /**
     * 区域id
     */
    private Long vrareasid;

    /**
     * 照片
     */
    private String photo;

    /**
     * vrstaff
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrstaffDomain(Long id, String name, Integer age, Integer level, Long vrareasid, String photo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
        this.vrareasid = vrareasid;
        this.photo = photo;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrstaffDomain() {
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
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 职级（0-4
     * @return level 职级（0-4
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 职级（0-4
     * @param level 职级（0-4
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 区域id
     * @return vrareasid 区域id
     */
    public Long getVrareasid() {
        return vrareasid;
    }

    /**
     * 区域id
     * @param vrareasid 区域id
     */
    public void setVrareasid(Long vrareasid) {
        this.vrareasid = vrareasid;
    }

    /**
     * 照片
     * @return photo 照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 照片
     * @param photo 照片
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}