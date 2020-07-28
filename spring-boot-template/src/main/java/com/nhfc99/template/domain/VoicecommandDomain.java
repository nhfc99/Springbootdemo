package com.nhfc99.template.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("语音数据")
@Data
public class VoicecommandDomain implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 语音指令
     */
    @ApiModelProperty("语音指令")
    private String vcommand;

    /**
     * 系统内部指令
     */
    @ApiModelProperty("系统内部指令")
    private String sid;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String mem;

    /**
     * 内容数据
     */
    @ApiModelProperty("内容数据")
    private String data;

    /**
     * voicecommand
     */
    private static final long serialVersionUID = 1L;

    /**
     * @mbggenerated 2020-06-18
     */
    public VoicecommandDomain(Long id, String vcommand, String sid, String mem) {
        this.id = id;
        this.vcommand = vcommand;
        this.sid = sid;
        this.mem = mem;
    }

    /**
     * @mbggenerated 2020-06-18
     */
    public VoicecommandDomain() {
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
     * 语音指令
     *
     * @return vcommand 语音指令
     */
    public String getVcommand() {
        return vcommand;
    }

    /**
     * 语音指令
     *
     * @param vcommand 语音指令
     */
    public void setVcommand(String vcommand) {
        this.vcommand = vcommand == null ? null : vcommand.trim();
    }

    /**
     * 系统内部指令
     *
     * @return sid 系统内部指令
     */
    public String getSid() {
        return sid;
    }

    /**
     * 系统内部指令
     *
     * @param sid 系统内部指令
     */
    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    /**
     * 备注
     *
     * @return mem 备注
     */
    public String getMem() {
        return mem;
    }

    /**
     * 备注
     *
     * @param mem 备注
     */
    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}