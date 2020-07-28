package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class CheckhistoryDomain implements Serializable {
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
     * 审核类型
     */
    private Integer checkType;

    /**
     * 信息编号
     */
    private String checkInfId;

    /**
     * 审核前状态
     */
    private Integer checkBeforeStatus;

    /**
     * 审核后状态
     */
    private Integer checkAfterStatus;

    /**
     * 审核描述
     */
    private String checkDescribe;

    /**
     * 备注信息
     */
    private String backMemo;

    /**
     * checkhistory
     */
    private static final long serialVersionUID = 1L;

    /**
     * @mbggenerated 2020-05-27
     */
    public CheckhistoryDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, Integer checkType, String checkInfId, Integer checkBeforeStatus, Integer checkAfterStatus, String checkDescribe, String backMemo) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.checkType = checkType;
        this.checkInfId = checkInfId;
        this.checkBeforeStatus = checkBeforeStatus;
        this.checkAfterStatus = checkAfterStatus;
        this.checkDescribe = checkDescribe;
        this.backMemo = backMemo;
    }

    /**
     * @mbggenerated 2020-05-27
     */
    public CheckhistoryDomain() {
        super();
    }

    /**
     * 主键编号
     *
     * @return Id 主键编号
     */
    public String getId() {
        return id;
    }

    /**
     * 主键编号
     *
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
     * 创建用户编号
     *
     * @return CreateUserId 创建用户编号
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建用户编号
     *
     * @param createUserId 创建用户编号
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * 创建用户名称
     *
     * @return CreateUserName 创建用户名称
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建用户名称
     *
     * @param createUserName 创建用户名称
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 最后编辑日期
     *
     * @return LastEditDate 最后编辑日期
     */
    public Date getLastEditDate() {
        return lastEditDate;
    }

    /**
     * 最后编辑日期
     *
     * @param lastEditDate 最后编辑日期
     */
    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    /**
     * 审核类型
     *
     * @return CheckType 审核类型
     */
    public Integer getCheckType() {
        return checkType;
    }

    /**
     * 审核类型
     *
     * @param checkType 审核类型
     */
    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    /**
     * 信息编号
     *
     * @return CheckInfId 信息编号
     */
    public String getCheckInfId() {
        return checkInfId;
    }

    /**
     * 信息编号
     *
     * @param checkInfId 信息编号
     */
    public void setCheckInfId(String checkInfId) {
        this.checkInfId = checkInfId == null ? null : checkInfId.trim();
    }

    /**
     * 审核前状态
     *
     * @return CheckBeforeStatus 审核前状态
     */
    public Integer getCheckBeforeStatus() {
        return checkBeforeStatus;
    }

    /**
     * 审核前状态
     *
     * @param checkBeforeStatus 审核前状态
     */
    public void setCheckBeforeStatus(Integer checkBeforeStatus) {
        this.checkBeforeStatus = checkBeforeStatus;
    }

    /**
     * 审核后状态
     *
     * @return CheckAfterStatus 审核后状态
     */
    public Integer getCheckAfterStatus() {
        return checkAfterStatus;
    }

    /**
     * 审核后状态
     *
     * @param checkAfterStatus 审核后状态
     */
    public void setCheckAfterStatus(Integer checkAfterStatus) {
        this.checkAfterStatus = checkAfterStatus;
    }

    /**
     * 审核描述
     *
     * @return CheckDescribe 审核描述
     */
    public String getCheckDescribe() {
        return checkDescribe;
    }

    /**
     * 审核描述
     *
     * @param checkDescribe 审核描述
     */
    public void setCheckDescribe(String checkDescribe) {
        this.checkDescribe = checkDescribe == null ? null : checkDescribe.trim();
    }

    /**
     * 备注信息
     *
     * @return BackMemo 备注信息
     */
    public String getBackMemo() {
        return backMemo;
    }

    /**
     * 备注信息
     *
     * @param backMemo 备注信息
     */
    public void setBackMemo(String backMemo) {
        this.backMemo = backMemo == null ? null : backMemo.trim();
    }
}