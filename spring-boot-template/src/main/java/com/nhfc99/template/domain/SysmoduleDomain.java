package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class SysmoduleDomain implements Serializable {
    /**
     * 主键编号
     */
    private String id;

    /**
     * 菜单名称
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
     * 图标类名
     */
    private String iconClass;

    /**
     * 页面地址
     */
    private String pageLink;

    /**
     * 展现形式
     */
    private String showType;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 展开
     */
    private Boolean isOpen;

    /**
     * 状态
     */
    private Boolean isValue;

    /**
     * 备注信息
     */
    private String backMemo;

    /**
     * sysmodule
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysmoduleDomain(String id, String name, Integer layoutLevel, String parentId, String parentName, String cascadeId, Date createDate, String createUserId, String createUserName, Date lastEditDate, String iconClass, String pageLink, String showType, Integer showOrder, Boolean isOpen, Boolean isValue, String backMemo) {
        this.id = id;
        this.name = name;
        this.layoutLevel = layoutLevel;
        this.parentId = parentId;
        this.parentName = parentName;
        this.cascadeId = cascadeId;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.iconClass = iconClass;
        this.pageLink = pageLink;
        this.showType = showType;
        this.showOrder = showOrder;
        this.isOpen = isOpen;
        this.isValue = isValue;
        this.backMemo = backMemo;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysmoduleDomain() {
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
     * 菜单名称
     * @return Name 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     * @param name 菜单名称
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
     * 图标类名
     * @return IconClass 图标类名
     */
    public String getIconClass() {
        return iconClass;
    }

    /**
     * 图标类名
     * @param iconClass 图标类名
     */
    public void setIconClass(String iconClass) {
        this.iconClass = iconClass == null ? null : iconClass.trim();
    }

    /**
     * 页面地址
     * @return PageLink 页面地址
     */
    public String getPageLink() {
        return pageLink;
    }

    /**
     * 页面地址
     * @param pageLink 页面地址
     */
    public void setPageLink(String pageLink) {
        this.pageLink = pageLink == null ? null : pageLink.trim();
    }

    /**
     * 展现形式
     * @return ShowType 展现形式
     */
    public String getShowType() {
        return showType;
    }

    /**
     * 展现形式
     * @param showType 展现形式
     */
    public void setShowType(String showType) {
        this.showType = showType == null ? null : showType.trim();
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
     * 展开
     * @return IsOpen 展开
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     * 展开
     * @param isOpen 展开
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 状态
     * @return IsValue 状态
     */
    public Boolean getIsValue() {
        return isValue;
    }

    /**
     * 状态
     * @param isValue 状态
     */
    public void setIsValue(Boolean isValue) {
        this.isValue = isValue;
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
}