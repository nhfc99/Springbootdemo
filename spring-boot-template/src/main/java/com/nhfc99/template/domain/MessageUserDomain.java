package com.nhfc99.template.domain;

import java.io.Serializable;

public class MessageUserDomain implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * messageuser
     */
    private static final long serialVersionUID = 1L;

    /**
     * @mbggenerated 2020-06-08
     */
    public MessageUserDomain(Long id, String name, String phone, Integer sort) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sort = sort;
    }

    /**
     * @mbggenerated 2020-06-08
     */
    public MessageUserDomain() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户名
     *
     * @return name 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 手机号
     *
     * @return phone 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 排序
     *
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}