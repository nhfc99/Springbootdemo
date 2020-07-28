package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class AttachfileDomain implements Serializable {
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
     * 附件分类
     */
    private Integer attachType;

    /**
     * 数据编号
     */
    private String dataInfoId;

    /**
     * 显示标题
     */
    private String showTitle;

    /**
     * 附件地址
     */
    private String attachUrl;

    /**
     * 文件类型
     */
    private String fileFormat;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * attachfile
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public AttachfileDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, Integer attachType, String dataInfoId, String showTitle, String attachUrl, String fileFormat, Integer showOrder) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.attachType = attachType;
        this.dataInfoId = dataInfoId;
        this.showTitle = showTitle;
        this.attachUrl = attachUrl;
        this.fileFormat = fileFormat;
        this.showOrder = showOrder;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public AttachfileDomain() {
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
     * 附件分类
     * @return AttachType 附件分类
     */
    public Integer getAttachType() {
        return attachType;
    }

    /**
     * 附件分类
     * @param attachType 附件分类
     */
    public void setAttachType(Integer attachType) {
        this.attachType = attachType;
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
     * 显示标题
     * @return ShowTitle 显示标题
     */
    public String getShowTitle() {
        return showTitle;
    }

    /**
     * 显示标题
     * @param showTitle 显示标题
     */
    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle == null ? null : showTitle.trim();
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
     * 文件类型
     * @return FileFormat 文件类型
     */
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * 文件类型
     * @param fileFormat 文件类型
     */
    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat == null ? null : fileFormat.trim();
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
}