package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class SysroleauthorizeDomain implements Serializable {
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
     * 角色编号
     */
    private String sysRoleId;

    /**
     * 数据类型
     */
    private Integer dataType;

    /**
     * 数据编号
     */
    private String dataId;

    /**
     * sysroleauthorize
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysroleauthorizeDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String sysRoleId, Integer dataType, String dataId) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.sysRoleId = sysRoleId;
        this.dataType = dataType;
        this.dataId = dataId;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysroleauthorizeDomain() {
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
     * 角色编号
     * @return SysRoleId 角色编号
     */
    public String getSysRoleId() {
        return sysRoleId;
    }

    /**
     * 角色编号
     * @param sysRoleId 角色编号
     */
    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId == null ? null : sysRoleId.trim();
    }

    /**
     * 数据类型
     * @return DataType 数据类型
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * 数据类型
     * @param dataType 数据类型
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 数据编号
     * @return DataId 数据编号
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * 数据编号
     * @param dataId 数据编号
     */
    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }
}