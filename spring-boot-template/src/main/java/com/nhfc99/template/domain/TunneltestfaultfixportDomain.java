package com.nhfc99.template.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TunneltestfaultfixportDomain implements Serializable {
    /**
     * 主键编号
     */
    private String id;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 项目编号
     */
    private String projectInfoId;

    /**
     * 隧道名称
     */
    private String tunnelName;

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
     * 是否缺陷
     */
    private Boolean isFault;

    /**
     * 是否已修复
     */
    private Boolean isFix;

    /**
     * 备注信息
     */
    private String backMemo;

    /**
     * 数据编号
     */
    private String dataInfoId;

    /**
     * 附件地址
     */
    private String attachUrl;

    /**
     * 修复报告编号
     */
    private String tunnelFixReportId;

    /**
     * 缺陷编号
     */
    private String tunnelTestFaultId;

    /**
     * 电子报告
     */
    private String fixReportFile;

    /**
     * 报告编号
     */
    private String reportNum;

    /**
     * 缺陷等级
     */
    private Integer faultLevel;

    /**
     * 修复量值
     */
    private String fixActualAmount;

    /**
     * 电子报告
     */
    private String testReportFile;

    /**
     * tunneltestfaultfixport
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-07-11
     */
    public TunneltestfaultfixportDomain(String id, Date createDate, String projectInfoId, String tunnelName, String tunnelInfoId, String tunnelTestReportId, Integer startKilometre, BigDecimal startMetre, Integer endKilometre, BigDecimal endMetre, BigDecimal faultLength, String faultType, String faultSite, String designAmount, String actualAmount, Boolean isFault, Boolean isFix, String backMemo, String dataInfoId, String attachUrl, String tunnelFixReportId, String tunnelTestFaultId, String fixReportFile, String reportNum, Integer faultLevel, String fixActualAmount, String testReportFile) {
        this.id = id;
        this.createDate = createDate;
        this.projectInfoId = projectInfoId;
        this.tunnelName = tunnelName;
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
        this.isFault = isFault;
        this.isFix = isFix;
        this.backMemo = backMemo;
        this.dataInfoId = dataInfoId;
        this.attachUrl = attachUrl;
        this.tunnelFixReportId = tunnelFixReportId;
        this.tunnelTestFaultId = tunnelTestFaultId;
        this.fixReportFile = fixReportFile;
        this.reportNum = reportNum;
        this.faultLevel = faultLevel;
        this.fixActualAmount = fixActualAmount;
        this.testReportFile = testReportFile;
    }

    /**
     *
     * @mbggenerated 2020-07-11
     */
    public TunneltestfaultfixportDomain() {
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
     * 隧道名称
     * @return TunnelName 隧道名称
     */
    public String getTunnelName() {
        return tunnelName;
    }

    /**
     * 隧道名称
     * @param tunnelName 隧道名称
     */
    public void setTunnelName(String tunnelName) {
        this.tunnelName = tunnelName == null ? null : tunnelName.trim();
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
     * 数据编号
     * @return DataInfoId 数据编号
     */
    public String getDataInfoId() {
        return dataInfoId;
    }

    /**
     * 数据编号
     * @param dataInfoId 数据编号
     */
    public void setDataInfoId(String dataInfoId) {
        this.dataInfoId = dataInfoId == null ? null : dataInfoId.trim();
    }

    /**
     * 附件地址
     * @return AttachUrl 附件地址
     */
    public String getAttachUrl() {
        return attachUrl;
    }

    /**
     * 附件地址
     * @param attachUrl 附件地址
     */
    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl == null ? null : attachUrl.trim();
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
}