package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class SysroleDomain implements Serializable {
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
     * 角色名称
     */
    private String roleName;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 是否有效
     */
    private Boolean isValue;

    /**
     * 备注
     */
    private String backMemo;

    /**
     * 工作范围（与项目和隧道相关，进行权限区分，不选择则代表拥有所有范围）
     */
    private String workRange;

    /**
     * 登录范围
     */
    private Integer powerRange;

    /**
     * 告警级别
     */
    private String warningLevel;

    /**
     * sysrole
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysroleDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String roleName, Integer showOrder, Boolean isValue, String backMemo, String workRange, Integer powerRange, String warningLevel) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.roleName = roleName;
        this.showOrder = showOrder;
        this.isValue = isValue;
        this.backMemo = backMemo;
        this.workRange = workRange;
        this.powerRange = powerRange;
        this.warningLevel = warningLevel;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysroleDomain() {
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
     * 角色名称
     * @return RoleName 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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
     * 是否有效
     * @return IsValue 是否有效
     */
    public Boolean getIsValue() {
        return isValue;
    }

    /**
     * 是否有效
     * @param isValue 是否有效
     */
    public void setIsValue(Boolean isValue) {
        this.isValue = isValue;
    }

    /**
     * 备注
     * @return BackMemo 备注
     */
    public String getBackMemo() {
        return backMemo;
    }

    /**
     * 备注
     * @param backMemo 备注
     */
    public void setBackMemo(String backMemo) {
        this.backMemo = backMemo == null ? null : backMemo.trim();
    }

    /**
     * 工作范围（与项目和隧道相关，进行权限区分，不选择则代表拥有所有范围）
     * @return WorkRange 工作范围（与项目和隧道相关，进行权限区分，不选择则代表拥有所有范围）
     */
    public String getWorkRange() {
        return workRange;
    }

    /**
     * 工作范围（与项目和隧道相关，进行权限区分，不选择则代表拥有所有范围）
     * @param workRange 工作范围（与项目和隧道相关，进行权限区分，不选择则代表拥有所有范围）
     */
    public void setWorkRange(String workRange) {
        this.workRange = workRange == null ? null : workRange.trim();
    }

    /**
     * 登录范围
     * @return PowerRange 登录范围
     */
    public Integer getPowerRange() {
        return powerRange;
    }

    /**
     * 登录范围
     * @param powerRange 登录范围
     */
    public void setPowerRange(Integer powerRange) {
        this.powerRange = powerRange;
    }

    /**
     * 告警级别
     * @return WarningLevel 告警级别
     */
    public String getWarningLevel() {
        return warningLevel;
    }

    /**
     * 告警级别
     * @param warningLevel 告警级别
     */
    public void setWarningLevel(String warningLevel) {
        this.warningLevel = warningLevel == null ? null : warningLevel.trim();
    }
}