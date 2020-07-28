package com.nhfc99.template.domain;

import java.io.Serializable;

public class SystemcommandDomain implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 指令值
     */
    private String value;

    /**
     * 备注
     */
    private String mem;

    /**
     * systemcommand
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-06-18
     */
    public SystemcommandDomain(Long id, String value, String mem) {
        this.id = id;
        this.value = value;
        this.mem = mem;
    }

    /**
     *
     * @mbggenerated 2020-06-18
     */
    public SystemcommandDomain() {
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
     * 指令值
     * @return value 指令值
     */
    public String getValue() {
        return value;
    }

    /**
     * 指令值
     * @param value 指令值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 备注
     * @return mem 备注
     */
    public String getMem() {
        return mem;
    }

    /**
     * 备注
     * @param mem 备注
     */
    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }
}