package com.nhfc99.template.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TunnelfixcrackdetailDomain implements Serializable {
    /**
     * 主键编号
     */
    private String id;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 创建用户编号
     */
    private String createUserId;

    /**
     * 创建用户名称
     */
    private String createUserName;

    /**
     * 最后编辑日期
     */
    private Date lastEditDate;

    /**
     * 项目编号
     */
    private String projectInfoId;

    /**
     * 隧道编号
     */
    private String tunnelInfoId;

    /**
     * 起始里程（公里）
     */
    private Integer startKilometre;

    /**
     * 起始里程（米）
     */
    private BigDecimal startMetre;

    /**
     * 衬砌缝里程（米）
     */
    private BigDecimal fixCrackMile;

    /**
     * tunnelfixcrackdetail
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelfixcrackdetailDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String tunnelInfoId, Integer startKilometre, BigDecimal startMetre, BigDecimal fixCrackMile) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.tunnelInfoId = tunnelInfoId;
        this.startKilometre = startKilometre;
        this.startMetre = startMetre;
        this.fixCrackMile = fixCrackMile;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelfixcrackdetailDomain() {
        super();
    }

    /**
     * 主键编号
     * @return Id 主键编号
     */
    public String getId() {
        return id;
    }

    /**
     * 主键编号
     * @param id 主键编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 创建日期
     * @return CreateDate 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 创建用户编号
     * @return CreateUserId 创建用户编号
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建用户编号
     * @param createUserId 创建用户编号
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * 创建用户名称
     * @return CreateUserName 创建用户名称
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建用户名称
     * @param createUserName 创建用户名称
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 最后编辑日期
     * @return LastEditDate 最后编辑日期
     */
    public Date getLastEditDate() {
        return lastEditDate;
    }

    /**
     * 最后编辑日期
     * @param lastEditDate 最后编辑日期
     */
    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    /**
     * 项目编号
     * @return ProjectInfoId 项目编号
     */
    public String getProjectInfoId() {
        return projectInfoId;
    }

    /**
     * 项目编号
     * @param projectInfoId 项目编号
     */
    public void setProjectInfoId(String projectInfoId) {
        this.projectInfoId = projectInfoId == null ? null : projectInfoId.trim();
    }

    /**
     * 隧道编号
     * @return TunnelInfoId 隧道编号
     */
    public String getTunnelInfoId() {
        return tunnelInfoId;
    }

    /**
     * 隧道编号
     * @param tunnelInfoId 隧道编号
     */
    public void setTunnelInfoId(String tunnelInfoId) {
        this.tunnelInfoId = tunnelInfoId == null ? null : tunnelInfoId.trim();
    }

    /**
     * 起始里程（公里）
     * @return StartKilometre 起始里程（公里）
     */
    public Integer getStartKilometre() {
        return startKilometre;
    }

    /**
     * 起始里程（公里）
     * @param startKilometre 起始里程（公里）
     */
    public void setStartKilometre(Integer startKilometre) {
        this.startKilometre = startKilometre;
    }

    /**
     * 起始里程（米）
     * @return StartMetre 起始里程（米）
     */
    public BigDecimal getStartMetre() {
        return startMetre;
    }

    /**
     * 起始里程（米）
     * @param startMetre 起始里程（米）
     */
    public void setStartMetre(BigDecimal startMetre) {
        this.startMetre = startMetre;
    }

    /**
     * 衬砌缝里程（米）
     * @return FixCrackMile 衬砌缝里程（米）
     */
    public BigDecimal getFixCrackMile() {
        return fixCrackMile;
    }

    /**
     * 衬砌缝里程（米）
     * @param fixCrackMile 衬砌缝里程（米）
     */
    public void setFixCrackMile(BigDecimal fixCrackMile) {
        this.fixCrackMile = fixCrackMile;
    }
}