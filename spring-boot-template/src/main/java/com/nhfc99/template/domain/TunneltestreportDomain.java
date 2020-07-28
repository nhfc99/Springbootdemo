package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class TunneltestreportDomain implements Serializable {
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
     * 报告编号
     */
    private String reportNum;

    /**
     * 检测时间
     */
    private Date testTime;

    /**
     * 施工单位
     */
    private String buildSite;

    /**
     * 监理单位
     */
    private String supervisorSite;

    /**
     * 检测内容
     */
    private String testContent;

    /**
     * 检测方法
     */
    private String testMethod;

    /**
     * 检测仪器
     */
    private String testMachine;

    /**
     * 检测结论
     */
    private String testConclusion;

    /**
     * 电子报告
     */
    private String testReportFile;

    /**
     * 报告状态
     */
    private Integer status;

    /**
     * tunneltestreport
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunneltestreportDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String reportNum, Date testTime, String buildSite, String supervisorSite, String testContent, String testMethod, String testMachine, String testConclusion, String testReportFile, Integer status) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.reportNum = reportNum;
        this.testTime = testTime;
        this.buildSite = buildSite;
        this.supervisorSite = supervisorSite;
        this.testContent = testContent;
        this.testMethod = testMethod;
        this.testMachine = testMachine;
        this.testConclusion = testConclusion;
        this.testReportFile = testReportFile;
        this.status = status;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunneltestreportDomain() {
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
     * 检测时间
     * @return TestTime 检测时间
     */
    public Date getTestTime() {
        return testTime;
    }

    /**
     * 检测时间
     * @param testTime 检测时间
     */
    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    /**
     * 施工单位
     * @return BuildSite 施工单位
     */
    public String getBuildSite() {
        return buildSite;
    }

    /**
     * 施工单位
     * @param buildSite 施工单位
     */
    public void setBuildSite(String buildSite) {
        this.buildSite = buildSite == null ? null : buildSite.trim();
    }

    /**
     * 监理单位
     * @return SupervisorSite 监理单位
     */
    public String getSupervisorSite() {
        return supervisorSite;
    }

    /**
     * 监理单位
     * @param supervisorSite 监理单位
     */
    public void setSupervisorSite(String supervisorSite) {
        this.supervisorSite = supervisorSite == null ? null : supervisorSite.trim();
    }

    /**
     * 检测内容
     * @return TestContent 检测内容
     */
    public String getTestContent() {
        return testContent;
    }

    /**
     * 检测内容
     * @param testContent 检测内容
     */
    public void setTestContent(String testContent) {
        this.testContent = testContent == null ? null : testContent.trim();
    }

    /**
     * 检测方法
     * @return TestMethod 检测方法
     */
    public String getTestMethod() {
        return testMethod;
    }

    /**
     * 检测方法
     * @param testMethod 检测方法
     */
    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod == null ? null : testMethod.trim();
    }

    /**
     * 检测仪器
     * @return TestMachine 检测仪器
     */
    public String getTestMachine() {
        return testMachine;
    }

    /**
     * 检测仪器
     * @param testMachine 检测仪器
     */
    public void setTestMachine(String testMachine) {
        this.testMachine = testMachine == null ? null : testMachine.trim();
    }

    /**
     * 检测结论
     * @return TestConclusion 检测结论
     */
    public String getTestConclusion() {
        return testConclusion;
    }

    /**
     * 检测结论
     * @param testConclusion 检测结论
     */
    public void setTestConclusion(String testConclusion) {
        this.testConclusion = testConclusion == null ? null : testConclusion.trim();
    }

    /**
     * 电子报告
     * @return TestReportFile 电子报告
     */
    public String getTestReportFile() {
        return testReportFile;
    }

    /**
     * 电子报告
     * @param testReportFile 电子报告
     */
    public void setTestReportFile(String testReportFile) {
        this.testReportFile = testReportFile == null ? null : testReportFile.trim();
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