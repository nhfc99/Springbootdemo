package com.nhfc99.template.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HomeQualityStatisticsAllAreaDomain implements Serializable {
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
     * 起始公里（公里）
     */
    private Integer startKilometre;

    /**
     * 起始米数（米）
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
     * 缺陷长度（米）
     */
    private BigDecimal faultLength;

    /**
     * 缺陷类型
     */
    private String faultType;

    /**
     * 缺陷位置
     */
    private String faultSite;

    /**
     * 设计量值
     */
    private String designAmount;

    /**
     * 实际量值
     */
    private String actualAmount;

    /**
     * 备注信息
     */
    private String backMemo;

    /**
     * 是否缺陷
     */
    private Boolean isFault;

    /**
     * 是否已修复
     */
    private Boolean isFix;

    /**
     * 修复报告编号
     */
    private String tunnelFixReportId;

    /**
     * 缺陷等级
     */
    private Integer faultLevel;

    /**
     * 是否推送
     */
    private Boolean isSendMsg;

    /**
     * 测线总长
     */
    private BigDecimal testLineLength;

    /**
     * 衬砌长度
     */
    private BigDecimal fixCrackLength;

    /**
     * 隧道长度
     */
    private BigDecimal tunnelLength;

    /**
     * 区域名称
     */
    private String areaname;

    /**
     * 项目名称
     */
    private String ProjectName;

    /**
     * homequalitystatisticsallarea
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-06-01
     */
    public HomeQualityStatisticsAllAreaDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String tunnelInfoId, String tunnelTestReportId, Integer startKilometre, BigDecimal startMetre, Integer endKilometre, BigDecimal endMetre, BigDecimal faultLength, String faultType, String faultSite, String designAmount, String actualAmount, String backMemo, Boolean isFault, Boolean isFix, String tunnelFixReportId, Integer faultLevel, Boolean isSendMsg, BigDecimal testLineLength, BigDecimal fixCrackLength, BigDecimal tunnelLength, String areaname, String ProjectName) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.tunnelInfoId = tunnelInfoId;
        this.tunnelTestReportId = tunnelTestReportId;
        this.startKilometre = startKilometre;
        this.startMetre = startMetre;
        this.endKilometre = endKilometre;
        this.endMetre = endMetre;
        this.faultLength = faultLength;
        this.faultType = faultType;
        this.faultSite = faultSite;
        this.designAmount = designAmount;
        this.actualAmount = actualAmount;
        this.backMemo = backMemo;
        this.isFault = isFault;
        this.isFix = isFix;
        this.tunnelFixReportId = tunnelFixReportId;
        this.faultLevel = faultLevel;
        this.isSendMsg = isSendMsg;
        this.testLineLength = testLineLength;
        this.fixCrackLength = fixCrackLength;
        this.tunnelLength = tunnelLength;
        this.areaname = areaname;
        this.ProjectName = ProjectName;
    }

    /**
     *
     * @mbggenerated 2020-06-01
     */
    public HomeQualityStatisticsAllAreaDomain() {
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
     * 起始公里（公里）
     * @return StartKilometre 起始公里（公里）
     */
    public Integer getStartKilometre() {
        return startKilometre;
    }

    /**
     * 起始公里（公里）
     * @param startKilometre 起始公里（公里）
     */
    public void setStartKilometre(Integer startKilometre) {
        this.startKilometre = startKilometre;
    }

    /**
     * 起始米数（米）
     * @return StartMetre 起始米数（米）
     */
    public BigDecimal getStartMetre() {
        return startMetre;
    }

    /**
     * 起始米数（米）
     * @param startMetre 起始米数（米）
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
     * 缺陷长度（米）
     * @return FaultLength 缺陷长度（米）
     */
    public BigDecimal getFaultLength() {
        return faultLength;
    }

    /**
     * 缺陷长度（米）
     * @param faultLength 缺陷长度（米）
     */
    public void setFaultLength(BigDecimal faultLength) {
        this.faultLength = faultLength;
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
     * 缺陷位置
     * @return FaultSite 缺陷位置
     */
    public String getFaultSite() {
        return faultSite;
    }

    /**
     * 缺陷位置
     * @param faultSite 缺陷位置
     */
    public void setFaultSite(String faultSite) {
        this.faultSite = faultSite == null ? null : faultSite.trim();
    }

    /**
     * 设计量值
     * @return DesignAmount 设计量值
     */
    public String getDesignAmount() {
        return designAmount;
    }

    /**
     * 设计量值
     * @param designAmount 设计量值
     */
    public void setDesignAmount(String designAmount) {
        this.designAmount = designAmount == null ? null : designAmount.trim();
    }

    /**
     * 实际量值
     * @return ActualAmount 实际量值
     */
    public String getActualAmount() {
        return actualAmount;
    }

    /**
     * 实际量值
     * @param actualAmount 实际量值
     */
    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount == null ? null : actualAmount.trim();
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
     * 是否缺陷
     * @return IsFault 是否缺陷
     */
    public Boolean getIsFault() {
        return isFault;
    }

    /**
     * 是否缺陷
     * @param isFault 是否缺陷
     */
    public void setIsFault(Boolean isFault) {
        this.isFault = isFault;
    }

    /**
     * 是否已修复
     * @return IsFix 是否已修复
     */
    public Boolean getIsFix() {
        return isFix;
    }

    /**
     * 是否已修复
     * @param isFix 是否已修复
     */
    public void setIsFix(Boolean isFix) {
        this.isFix = isFix;
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
     * 是否推送
     * @return IsSendMsg 是否推送
     */
    public Boolean getIsSendMsg() {
        return isSendMsg;
    }

    /**
     * 是否推送
     * @param isSendMsg 是否推送
     */
    public void setIsSendMsg(Boolean isSendMsg) {
        this.isSendMsg = isSendMsg;
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

    /**
     * 衬砌长度
     * @return FixCrackLength 衬砌长度
     */
    public BigDecimal getFixCrackLength() {
        return fixCrackLength;
    }

    /**
     * 衬砌长度
     * @param fixCrackLength 衬砌长度
     */
    public void setFixCrackLength(BigDecimal fixCrackLength) {
        this.fixCrackLength = fixCrackLength;
    }

    /**
     * 隧道长度
     * @return TunnelLength 隧道长度
     */
    public BigDecimal getTunnelLength() {
        return tunnelLength;
    }

    /**
     * 隧道长度
     * @param tunnelLength 隧道长度
     */
    public void setTunnelLength(BigDecimal tunnelLength) {
        this.tunnelLength = tunnelLength;
    }

    /**
     * 区域名称
     * @return areaname 区域名称
     */
    public String getAreaname() {
        return areaname;
    }

    /**
     * 区域名称
     * @param areaname 区域名称
     */
    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    /**
     * 项目名称
     * @return
     */
    public String getProjectName() {
        return ProjectName;
    }

    /**
     * 项目名称
     * @param projectName
     */
    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
}