package com.nhfc99.template.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TunneltestlinedetailDomain implements Serializable {
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
     * 检测报告编号
     */
    private String tunnelTestReportId;

    /**
     * 检测线类型
     */
    private String testLineType;

    /**
     * 检测部位
     */
    private String testPosition;

    /**
     * 起始里程（公里）
     */
    private Integer startKilometre;

    /**
     * 起始里程（米）
     */
    private BigDecimal startMetre;

    /**
     * 中止里程（公里）
     */
    private Integer endKilometre;

    /**
     * 中止里程（米）
     */
    private BigDecimal endMetre;

    /**
     * 测线总长
     */
    private BigDecimal testLineLength;

    /**
     * tunneltestlinedetail
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunneltestlinedetailDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String tunnelInfoId, String tunnelTestReportId, String testLineType, String testPosition, Integer startKilometre, BigDecimal startMetre, Integer endKilometre, BigDecimal endMetre, BigDecimal testLineLength) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.tunnelInfoId = tunnelInfoId;
        this.tunnelTestReportId = tunnelTestReportId;
        this.testLineType = testLineType;
        this.testPosition = testPosition;
        this.startKilometre = startKilometre;
        this.startMetre = startMetre;
        this.endKilometre = endKilometre;
        this.endMetre = endMetre;
        this.testLineLength = testLineLength;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunneltestlinedetailDomain() {
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
     * 检测报告编号
     * @return TunnelTestReportId 检测报告编号
     */
    public String getTunnelTestReportId() {
        return tunnelTestReportId;
    }

    /**
     * 检测报告编号
     * @param tunnelTestReportId 检测报告编号
     */
    public void setTunnelTestReportId(String tunnelTestReportId) {
        this.tunnelTestReportId = tunnelTestReportId == null ? null : tunnelTestReportId.trim();
    }

    /**
     * 检测线类型
     * @return TestLineType 检测线类型
     */
    public String getTestLineType() {
        return testLineType;
    }

    /**
     * 检测线类型
     * @param testLineType 检测线类型
     */
    public void setTestLineType(String testLineType) {
        this.testLineType = testLineType == null ? null : testLineType.trim();
    }

    /**
     * 检测部位
     * @return TestPosition 检测部位
     */
    public String getTestPosition() {
        return testPosition;
    }

    /**
     * 检测部位
     * @param testPosition 检测部位
     */
    public void setTestPosition(String testPosition) {
        this.testPosition = testPosition == null ? null : testPosition.trim();
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
     * 中止里程（公里）
     * @return EndKilometre 中止里程（公里）
     */
    public Integer getEndKilometre() {
        return endKilometre;
    }

    /**
     * 中止里程（公里）
     * @param endKilometre 中止里程（公里）
     */
    public void setEndKilometre(Integer endKilometre) {
        this.endKilometre = endKilometre;
    }

    /**
     * 中止里程（米）
     * @return EndMetre 中止里程（米）
     */
    public BigDecimal getEndMetre() {
        return endMetre;
    }

    /**
     * 中止里程（米）
     * @param endMetre 中止里程（米）
     */
    public void setEndMetre(BigDecimal endMetre) {
        this.endMetre = endMetre;
    }

    /**
     * 测线总长
     * @return TestLineLength 测线总长
     */
    public BigDecimal getTestLineLength() {
        return testLineLength;
    }

    /**
     * 测线总长
     * @param testLineLength 测线总长
     */
    public void setTestLineLength(BigDecimal testLineLength) {
        this.testLineLength = testLineLength;
    }
}