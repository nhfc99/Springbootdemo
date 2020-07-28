package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class TunneltestfaultmessageDomain implements Serializable {
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
     * 报告编号
     */
    private String tunnelTestReportId;

    /**
     * 缺陷编号
     */
    private String tunnelTestFaultId;

    /**
     * 缺陷类型
     */
    private String faultType;

    /**
     * 缺陷等级
     */
    private Integer faultLevel;

    /**
     * 发送内容
     */
    private String messageContent;

    /**
     * 接收人员编号
     */
    private String receiveUserId;

    /**
     * 备注信息
     */
    private String backMemo;

    /**
     * 状态
     */
    private Integer status;

    /**
     * tunneltestfaultmessage
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunneltestfaultmessageDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String tunnelInfoId, String tunnelTestReportId, String tunnelTestFaultId, String faultType, Integer faultLevel, String messageContent, String receiveUserId, String backMemo, Integer status) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.tunnelInfoId = tunnelInfoId;
        this.tunnelTestReportId = tunnelTestReportId;
        this.tunnelTestFaultId = tunnelTestFaultId;
        this.faultType = faultType;
        this.faultLevel = faultLevel;
        this.messageContent = messageContent;
        this.receiveUserId = receiveUserId;
        this.backMemo = backMemo;
        this.status = status;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunneltestfaultmessageDomain() {
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
     * 报告编号
     * @return TunnelTestReportId 报告编号
     */
    public String getTunnelTestReportId() {
        return tunnelTestReportId;
    }

    /**
     * 报告编号
     * @param tunnelTestReportId 报告编号
     */
    public void setTunnelTestReportId(String tunnelTestReportId) {
        this.tunnelTestReportId = tunnelTestReportId == null ? null : tunnelTestReportId.trim();
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
     * 缺陷类型
     * @return FaultType 缺陷类型
     */
    public String getFaultType() {
        return faultType;
    }

    /**
     * 缺陷类型
     * @param faultType 缺陷类型
     */
    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    /**
     * 缺陷等级
     * @return FaultLevel 缺陷等级
     */
    public Integer getFaultLevel() {
        return faultLevel;
    }

    /**
     * 缺陷等级
     * @param faultLevel 缺陷等级
     */
    public void setFaultLevel(Integer faultLevel) {
        this.faultLevel = faultLevel;
    }

    /**
     * 发送内容
     * @return MessageContent 发送内容
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 发送内容
     * @param messageContent 发送内容
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    /**
     * 接收人员编号
     * @return ReceiveUserId 接收人员编号
     */
    public String getReceiveUserId() {
        return receiveUserId;
    }

    /**
     * 接收人员编号
     * @param receiveUserId 接收人员编号
     */
    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId == null ? null : receiveUserId.trim();
    }

    /**
     * 备注信息
     * @return BackMemo 备注信息
     */
    public String getBackMemo() {
        return backMemo;
    }

    /**
     * 备注信息
     * @param backMemo 备注信息
     */
    public void setBackMemo(String backMemo) {
        this.backMemo = backMemo == null ? null : backMemo.trim();
    }

    /**
     * 状态
     * @return Status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}