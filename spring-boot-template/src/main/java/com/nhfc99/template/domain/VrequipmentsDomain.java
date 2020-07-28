package com.nhfc99.template.domain;

import java.io.Serializable;

public class VrequipmentsDomain implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 型号
     */
    private String type;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 图片
     */
    private String img;

    /**
     * vrequipments
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrequipmentsDomain(Long id, String name, String type, Integer count, String img) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.count = count;
        this.img = img;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrequipmentsDomain() {
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
     * 设备名称
     * @return name 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 型号
     * @return type 型号
     */
    public String getType() {
        return type;
    }

    /**
     * 型号
     * @param type 型号
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 数量
     * @return count 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 数量
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
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