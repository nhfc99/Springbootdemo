package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class TunnelfixreportDomain implements Serializable {
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
    private String reportNum;

    /**
     * 报告时间
     */
    private Date testTime;

    /**
     * 报告结论
     */
    private String testConclusion;

    /**
     * 电子报告
     */
    private String fixReportFile;

    /**
     * 报告状态
     */
    private Integer status;

    /**
     * tunnelfixreport
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelfixreportDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String tunnelInfoId, String reportNum, Date testTime, String testConclusion, String fixReportFile, Integer status) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.tunnelInfoId = tunnelInfoId;
        this.reportNum = reportNum;
        this.testTime = testTime;
        this.testConclusion = testConclusion;
        this.fixReportFile = fixReportFile;
        this.status = status;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelfixreportDomain() {
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
     * @return ReportNum 报告编号
     */
    public String getReportNum() {
        return reportNum;
    }

    /**
     * 报告编号
     * @param reportNum 报告编号
     */
    public void setReportNum(String reportNum) {
        this.reportNum = reportNum == null ? null : reportNum.trim();
    }

    /**
     * 报告时间
     * @return TestTime 报告时间
     */
    public Date getTestTime() {
        return testTime;
    }

    /**
     * 报告时间
     * @param testTime 报告时间
     */
    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    /**
     * 报告结论
     * @return TestConclusion 报告结论
     */
    public String getTestConclusion() {
        return testConclusion;
    }

    /**
     * 报告结论
     * @param testConclusion 报告结论
     */
    public void setTestConclusion(String testConclusion) {
        this.testConclusion = testConclusion == null ? null : testConclusion.trim();
    }

    /**
     * 电子报告
     * @return FixReportFile 电子报告
     */
    public String getFixReportFile() {
        return fixReportFile;
    }

    /**
     * 电子报告
     * @param fixReportFile 电子报告
     */
    public void setFixReportFile(String fixReportFile) {
        this.fixReportFile = fixReportFile == null ? null : fixReportFile.trim();
    }

    /**
     * 报告状态
     * @return Status 报告状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 报告状态
     * @param status 报告状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}