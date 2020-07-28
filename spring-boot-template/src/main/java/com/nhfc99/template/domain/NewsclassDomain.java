package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class NewsclassDomain implements Serializable {
    /**
     * 主键编号
     */
    private String id;

    /**
     * 备注信息
     */
    private String backMemo;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 所在层级
     */
    private Integer layoutLevel;

    /**
     * 父级编号
     */
    private String parentId;

    /**
     * 
     */
    private String parentName;

    /**
     * 
     */
    private String cascadeId;

    /**
     * 封面图片
     */
    private String coverPic;

    /**
     * SEO描述
     */
    private String seoDescription;

    /**
     * SEO关键词
     */
    private String seoKeywords;

    /**
     * SEO标题
     */
    private String seoTitle;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 类型状态
     */
    private Integer status;

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
     * newsclass
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public NewsclassDomain(String id, String backMemo, String name, Integer layoutLevel, String parentId, String parentName, String cascadeId, String coverPic, String seoDescription, String seoKeywords, String seoTitle, Integer showOrder, Integer status, Date createDate, String createUserId, String createUserName, Date lastEditDate) {
        this.id = id;
        this.backMemo = backMemo;
        this.name = name;
        this.layoutLevel = layoutLevel;
        this.parentId = parentId;
        this.parentName = parentName;
        this.cascadeId = cascadeId;
        this.coverPic = coverPic;
        this.seoDescription = seoDescription;
        this.seoKeywords = seoKeywords;
        this.seoTitle = seoTitle;
        this.showOrder = showOrder;
        this.status = status;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public NewsclassDomain() {
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
     * 类型名称
     * @return Name 类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 类型名称
     * @param name 类型名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所在层级
     * @return LayoutLevel 所在层级
     */
    public Integer getLayoutLevel() {
        return layoutLevel;
    }

    /**
     * 所在层级
     * @param layoutLevel 所在层级
     */
    public void setLayoutLevel(Integer layoutLevel) {
        this.layoutLevel = layoutLevel;
    }

    /**
     * 父级编号
     * @return ParentId 父级编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 父级编号
     * @param parentId 父级编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 
     * @return ParentName 
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 
     * @param parentName 
     */
    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    /**
     * 
     * @return CascadeId 
     */
    public String getCascadeId() {
        return cascadeId;
    }

    /**
     * 
     * @param cascadeId 
     */
    public void setCascadeId(String cascadeId) {
        this.cascadeId = cascadeId == null ? null : cascadeId.trim();
    }

    /**
     * 封面图片
     * @return CoverPic 封面图片
     */
    public String getCoverPic() {
        return coverPic;
    }

    /**
     * 封面图片
     * @param coverPic 封面图片
     */
    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic == null ? null : coverPic.trim();
    }

    /**
     * SEO描述
     * @return SeoDescription SEO描述
     */
    public String getSeoDescription() {
        return seoDescription;
    }

    /**
     * SEO描述
     * @param seoDescription SEO描述
     */
    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    /**
     * SEO关键词
     * @return SeoKeywords SEO关键词
     */
    public String getSeoKeywords() {
        return seoKeywords;
    }

    /**
     * SEO关键词
     * @param seoKeywords SEO关键词
     */
    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    /**
     * SEO标题
     * @return SeoTitle SEO标题
     */
    public String getSeoTitle() {
        return seoTitle;
    }

    /**
     * SEO标题
     * @param seoTitle SEO标题
     */
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
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
     * 类型状态
     * @return Status 类型状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 类型状态
     * @param status 类型状态
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}