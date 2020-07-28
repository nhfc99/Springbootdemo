package com.nhfc99.template.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AreaprojectTunnelinfoTestfaultDomain implements Serializable {
    /**
     * 主键编号
     */
    private String id;

    /**
     * 缺陷长度（米）
     */
    private BigDecimal faultLength;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 缺陷类型
     */
    private String faultType;

    /**
     * 是否缺陷
     */
    private Boolean isFault;

    /**
     * 是否已修复
     */
    private Boolean isFix;

    /**
     * 缺陷等级
     */
    private Integer faultLevel;

    /**
     * 主键编号
     */
    private String tunnelId;

    /**
     * 项目编号
     */
    private String projectInfoId;

    /**
     * 隧道名称
     */
    private String tunnelName;

    /**
     * 隧道长度
     */
    private BigDecimal tunnelLength;

    /**
     * 已建长度
     */
    private BigDecimal buildLength;

    /**
     * 已检长度
     */
    private BigDecimal testLength;

    /**
     * 衬砌长度
     */
    private BigDecimal fixCrackLength;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 所属区域
     */
    private String projectAreaId;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * areaprojecttunnelinfotestfault
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-06-23
     */
    public AreaprojectTunnelinfoTestfaultDomain(String id, Date createDate, BigDecimal faultLength, String faultType, Boolean isFault, Boolean isFix, Integer faultLevel, String tunnelId, String projectInfoId, String tunnelName, BigDecimal tunnelLength, BigDecimal buildLength, BigDecimal testLength, BigDecimal fixCrackLength, String projectName, String projectAreaId, String areaName) {
        this.id = id;
        this.createDate = createDate;
        this.faultLength = faultLength;
        this.faultType = faultType;
        this.isFault = isFault;
        this.isFix = isFix;
        this.faultLevel = faultLevel;
        this.tunnelId = tunnelId;
        this.projectInfoId = projectInfoId;
        this.tunnelName = tunnelName;
        this.tunnelLength = tunnelLength;
        this.buildLength = buildLength;
        this.testLength = testLength;
        this.fixCrackLength = fixCrackLength;
        this.projectName = projectName;
        this.projectAreaId = projectAreaId;
        this.areaName = areaName;
    }

    /**
     *
     * @mbggenerated 2020-06-23
     */
    public AreaprojectTunnelinfoTestfaultDomain() {
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
     *
     * @return CreateDate 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
     * 主键编号
     * @return tunnelId 主键编号
     */
    public String getTunnelId() {
        return tunnelId;
    }

    /**
     * 主键编号
     * @param tunnelId 主键编号
     */
    public void setTunnelId(String tunnelId) {
        this.tunnelId = tunnelId == null ? null : tunnelId.trim();
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
     * 已建长度
     * @return BuildLength 已建长度
     */
    public BigDecimal getBuildLength() {
        return buildLength;
    }

    /**
     * 已建长度
     * @param buildLength 已建长度
     */
    public void setBuildLength(BigDecimal buildLength) {
        this.buildLength = buildLength;
    }

    /**
     * 已检长度
     * @return TestLength 已检长度
     */
    public BigDecimal getTestLength() {
        return testLength;
    }

    /**
     * 已检长度
     * @param testLength 已检长度
     */
    public void setTestLength(BigDecimal testLength) {
        this.testLength = testLength;
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
     * 项目名称
     * @return ProjectName 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 所属区域
     * @return ProjectAreaId 所属区域
     */
    public String getProjectAreaId() {
        return projectAreaId;
    }

    /**
     * 所属区域
     * @param projectAreaId 所属区域
     */
    public void setProjectAreaId(String projectAreaId) {
        this.projectAreaId = projectAreaId == null ? null : projectAreaId.trim();
    }

    /**
     * 区域名称
     * @return AreaName 区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 区域名称
     * @param areaName 区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }
}