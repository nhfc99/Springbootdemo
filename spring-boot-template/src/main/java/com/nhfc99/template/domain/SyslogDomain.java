package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class SyslogDomain implements Serializable {
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
     * 模块名称
     */
    private String moduleName;

    /**
     * 操作类型
     */
    private String ctrlType;

    /**
     * 操作结果
     */
    private Boolean ctrlResult;

    /**
     * IP地址
     */
    private String IPAddress;

    /**
     * IP地址详情
     */
    private String IPAddressName;

    /**
     * 详情描述
     */
    private String description;

    /**
     * syslog
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SyslogDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String moduleName, String ctrlType, Boolean ctrlResult, String IPAddress, String IPAddressName, String description) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.moduleName = moduleName;
        this.ctrlType = ctrlType;
        this.ctrlResult = ctrlResult;
        this.IPAddress = IPAddress;
        this.IPAddressName = IPAddressName;
        this.description = description;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SyslogDomain() {
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
     * 模块名称
     * @return ModuleName 模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 模块名称
     * @param moduleName 模块名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 操作类型
     * @return CtrlType 操作类型
     */
    public String getCtrlType() {
        return ctrlType;
    }

    /**
     * 操作类型
     * @param ctrlType 操作类型
     */
    public void setCtrlType(String ctrlType) {
        this.ctrlType = ctrlType == null ? null : ctrlType.trim();
    }

    /**
     * 操作结果
     * @return CtrlResult 操作结果
     */
    public Boolean getCtrlResult() {
        return ctrlResult;
    }

    /**
     * 操作结果
     * @param ctrlResult 操作结果
     */
    public void setCtrlResult(Boolean ctrlResult) {
        this.ctrlResult = ctrlResult;
    }

    /**
     * IP地址
     * @return IPAddress IP地址
     */
    public String getIPAddress() {
        return IPAddress;
    }

    /**
     * IP地址
     * @param IPAddress IP地址
     */
    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress == null ? null : IPAddress.trim();
    }

    /**
     * IP地址详情
     * @return IPAddressName IP地址详情
     */
    public String getIPAddressName() {
        return IPAddressName;
    }

    /**
     * IP地址详情
     * @param IPAddressName IP地址详情
     */
    public void setIPAddressName(String IPAddressName) {
        this.IPAddressName = IPAddressName == null ? null : IPAddressName.trim();
    }

    /**
     * 详情描述
     * @return Description 详情描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 详情描述
     * @param description 详情描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}