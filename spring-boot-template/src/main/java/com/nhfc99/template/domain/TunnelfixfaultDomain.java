package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class TunnelfixfaultDomain implements Serializable {
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
     * 修复报告编号
     */
    private String tunnelFixReportId;

    /**
     * 缺陷编号
     */
    private String tunnelTestFaultId;

    /**
     * 修复量值
     */
    private String fixActualAmount;

    /**
     * 修复备注
     */
    private String fixBackMemo;

    /**
     * tunnelfixfault
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelfixfaultDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String tunnelInfoId, String tunnelFixReportId, String tunnelTestFaultId, String fixActualAmount, String fixBackMemo) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.tunnelInfoId = tunnelInfoId;
        this.tunnelFixReportId = tunnelFixReportId;
        this.tunnelTestFaultId = tunnelTestFaultId;
        this.fixActualAmount = fixActualAmount;
        this.fixBackMemo = fixBackMemo;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelfixfaultDomain() {
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
     * 修复报告编号
     * @return TunnelFixReportId 修复报告编号
     */
    public String getTunnelFixReportId() {
        return tunnelFixReportId;
    }

    /**
     * 修复报告编号
     * @param tunnelFixReportId 修复报告编号
     */
    public void setTunnelFixReportId(String tunnelFixReportId) {
        this.tunnelFixReportId = tunnelFixReportId == null ? null : tunnelFixReportId.trim();
    }

    /**
     * 缺陷编号
     * @return TunnelTestFaultId 缺陷编号
     */
    public String getTunnelTestFaultId() {
        return tunnelTestFaultId;
    }

    /**
     * 缺陷编号
     * @param tunnelTestFaultId 缺陷编号
     */
    public void setTunnelTestFaultId(String tunnelTestFaultId) {
        this.tunnelTestFaultId = tunnelTestFaultId == null ? null : tunnelTestFaultId.trim();
    }

    /**
     * 修复量值
     * @return FixActualAmount 修复量值
     */
    public String getFixActualAmount() {
        return fixActualAmount;
    }

    /**
     * 修复量值
     * @param fixActualAmount 修复量值
     */
    public void setFixActualAmount(String fixActualAmount) {
        this.fixActualAmount = fixActualAmount == null ? null : fixActualAmount.trim();
    }

    /**
     * 修复备注
     * @return FixBackMemo 修复备注
     */
    public String getFixBackMemo() {
        return fixBackMemo;
    }

    /**
     * 修复备注
     * @param fixBackMemo 修复备注
     */
    public void setFixBackMemo(String fixBackMemo) {
        this.fixBackMemo = fixBackMemo == null ? null : fixBackMemo.trim();
    }
}