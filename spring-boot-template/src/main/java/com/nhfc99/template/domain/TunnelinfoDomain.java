package com.nhfc99.template.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TunnelinfoDomain implements Serializable {
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
     * 隧道名称
     */
    private String tunnelName;

    /**
     * 桩号代码
     */
    private String pileNumCode;

    /**
     * 起始里程（公里）
     */
    private Integer startKilometre;

    /**
     * 起始里程（米）
     */
    private BigDecimal startMetre;

    /**
     * 终点里程（公里）
     */
    private Integer endKilometre;

    /**
     * 终点里程（米）
     */
    private BigDecimal endMetre;

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
     * 工程地点
     */
    private String buildAddress;

    /**
     * 隧道展示图（列表）
     */
    private String tunnelShowPic;

    /**
     * 隧道展示图（详情）
     */
    private String tunnelShowDetailPic;

    /**
     * 隧道描述
     */
    private String tunnelDescribe;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 统计状态
     */
    private Integer totalStatus;

    /**
     * 隧道状态
     */
    private Integer status;

    /**
     * tunnelinfo
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelinfoDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectInfoId, String tunnelName, String pileNumCode, Integer startKilometre, BigDecimal startMetre, Integer endKilometre, BigDecimal endMetre, BigDecimal tunnelLength, BigDecimal buildLength, BigDecimal testLength, BigDecimal fixCrackLength, String buildAddress, String tunnelShowPic, String tunnelShowDetailPic, String tunnelDescribe, Integer showOrder, Integer totalStatus, Integer status) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectInfoId = projectInfoId;
        this.tunnelName = tunnelName;
        this.pileNumCode = pileNumCode;
        this.startKilometre = startKilometre;
        this.startMetre = startMetre;
        this.endKilometre = endKilometre;
        this.endMetre = endMetre;
        this.tunnelLength = tunnelLength;
        this.buildLength = buildLength;
        this.testLength = testLength;
        this.fixCrackLength = fixCrackLength;
        this.buildAddress = buildAddress;
        this.tunnelShowPic = tunnelShowPic;
        this.tunnelShowDetailPic = tunnelShowDetailPic;
        this.tunnelDescribe = tunnelDescribe;
        this.showOrder = showOrder;
        this.totalStatus = totalStatus;
        this.status = status;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public TunnelinfoDomain() {
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
     * 桩号代码
     * @return PileNumCode 桩号代码
     */
    public String getPileNumCode() {
        return pileNumCode;
    }

    /**
     * 桩号代码
     * @param pileNumCode 桩号代码
     */
    public void setPileNumCode(String pileNumCode) {
        this.pileNumCode = pileNumCode == null ? null : pileNumCode.trim();
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
     * 终点里程（公里）
     * @return EndKilometre 终点里程（公里）
     */
    public Integer getEndKilometre() {
        return endKilometre;
    }

    /**
     * 终点里程（公里）
     * @param endKilometre 终点里程（公里）
     */
    public void setEndKilometre(Integer endKilometre) {
        this.endKilometre = endKilometre;
    }

    /**
     * 终点里程（米）
     * @return EndMetre 终点里程（米）
     */
    public BigDecimal getEndMetre() {
        return endMetre;
    }

    /**
     * 终点里程（米）
     * @param endMetre 终点里程（米）
     */
    public void setEndMetre(BigDecimal endMetre) {
        this.endMetre = endMetre;
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
     * 工程地点
     * @return BuildAddress 工程地点
     */
    public String getBuildAddress() {
        return buildAddress;
    }

    /**
     * 工程地点
     * @param buildAddress 工程地点
     */
    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress == null ? null : buildAddress.trim();
    }

    /**
     * 隧道展示图（列表）
     * @return TunnelShowPic 隧道展示图（列表）
     */
    public String getTunnelShowPic() {
        return tunnelShowPic;
    }

    /**
     * 隧道展示图（列表）
     * @param tunnelShowPic 隧道展示图（列表）
     */
    public void setTunnelShowPic(String tunnelShowPic) {
        this.tunnelShowPic = tunnelShowPic == null ? null : tunnelShowPic.trim();
    }

    /**
     * 隧道展示图（详情）
     * @return TunnelShowDetailPic 隧道展示图（详情）
     */
    public String getTunnelShowDetailPic() {
        return tunnelShowDetailPic;
    }

    /**
     * 隧道展示图（详情）
     * @param tunnelShowDetailPic 隧道展示图（详情）
     */
    public void setTunnelShowDetailPic(String tunnelShowDetailPic) {
        this.tunnelShowDetailPic = tunnelShowDetailPic == null ? null : tunnelShowDetailPic.trim();
    }

    /**
     * 隧道描述
     * @return TunnelDescribe 隧道描述
     */
    public String getTunnelDescribe() {
        return tunnelDescribe;
    }

    /**
     * 隧道描述
     * @param tunnelDescribe 隧道描述
     */
    public void setTunnelDescribe(String tunnelDescribe) {
        this.tunnelDescribe = tunnelDescribe == null ? null : tunnelDescribe.trim();
    }

    /**
     * 显示顺序
     * @return ShowOrder 显示顺序
     */
    public Integer getShowOrder() {
        return showOrder;
    }

    /**
     * 显示顺序
     * @param showOrder 显示顺序
     */
    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * 统计状态
     * @return TotalStatus 统计状态
     */
    public Integer getTotalStatus() {
        return totalStatus;
    }

    /**
     * 统计状态
     * @param totalStatus 统计状态
     */
    public void setTotalStatus(Integer totalStatus) {
        this.totalStatus = totalStatus;
    }

    /**
     * 隧道状态
     * @return Status 隧道状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 隧道状态
     * @param status 隧道状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}