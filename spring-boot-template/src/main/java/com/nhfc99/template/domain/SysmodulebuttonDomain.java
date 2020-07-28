package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class SysmodulebuttonDomain implements Serializable {
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
     * 菜单编号
     */
    private String sysModuleId;

    /**
     * 按钮位置
     */
    private String buttonSite;

    /**
     * 控件编号
     */
    private String enCode;

    /**
     * 页面事件
     */
    private String jsEvent;

    /**
     * 页面地址
     */
    private String pageLink;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 状态
     */
    private Boolean isValue;

    /**
     * 备注信息
     */
    private String backMemo;

    /**
     * sysmodulebutton
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysmodulebuttonDomain(String id, String name, Integer layoutLevel, String parentId, String parentName, String cascadeId, Date createDate, String createUserId, String createUserName, Date lastEditDate, String sysModuleId, String buttonSite, String enCode, String jsEvent, String pageLink, Integer showOrder, Boolean isValue, String backMemo) {
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
        this.sysModuleId = sysModuleId;
        this.buttonSite = buttonSite;
        this.enCode = enCode;
        this.jsEvent = jsEvent;
        this.pageLink = pageLink;
        this.showOrder = showOrder;
        this.isValue = isValue;
        this.backMemo = backMemo;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysmodulebuttonDomain() {
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
     * 菜单编号
     * @return SysModuleId 菜单编号
     */
    public String getSysModuleId() {
        return sysModuleId;
    }

    /**
     * 菜单编号
     * @param sysModuleId 菜单编号
     */
    public void setSysModuleId(String sysModuleId) {
        this.sysModuleId = sysModuleId == null ? null : sysModuleId.trim();
    }

    /**
     * 按钮位置
     * @return ButtonSite 按钮位置
     */
    public String getButtonSite() {
        return buttonSite;
    }

    /**
     * 按钮位置
     * @param buttonSite 按钮位置
     */
    public void setButtonSite(String buttonSite) {
        this.buttonSite = buttonSite == null ? null : buttonSite.trim();
    }

    /**
     * 控件编号
     * @return EnCode 控件编号
     */
    public String getEnCode() {
        return enCode;
    }

    /**
     * 控件编号
     * @param enCode 控件编号
     */
    public void setEnCode(String enCode) {
        this.enCode = enCode == null ? null : enCode.trim();
    }

    /**
     * 页面事件
     * @return JsEvent 页面事件
     */
    public String getJsEvent() {
        return jsEvent;
    }

    /**
     * 页面事件
     * @param jsEvent 页面事件
     */
    public void setJsEvent(String jsEvent) {
        this.jsEvent = jsEvent == null ? null : jsEvent.trim();
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