package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class ProjectinfoDomain implements Serializable {
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
     * 项目名称
     */
    private String projectName;

    /**
     * 所属区域
     */
    private String projectAreaId;

    /**
     * 所属分类
     */
    private String belongCategory;

    /**
     * 项目部名称
     */
    private String projectSiteName;

    /**
     * 项目地点
     */
    private String projectAddress;

    /**
     * 项目展示图（列表）
     */
    private String projectShowPic;

    /**
     * 项目视频
     */
    private String projectShowVideo;

    /**
     * 项目描述
     */
    private String projectDescribe;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 项目状态
     */
    private Integer status;

    /**
     * projectinfo
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public ProjectinfoDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, String projectName, String projectAreaId, String belongCategory, String projectSiteName, String projectAddress, String projectShowPic, String projectShowVideo, String projectDescribe, Integer showOrder, Integer status) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.projectName = projectName;
        this.projectAreaId = projectAreaId;
        this.belongCategory = belongCategory;
        this.projectSiteName = projectSiteName;
        this.projectAddress = projectAddress;
        this.projectShowPic = projectShowPic;
        this.projectShowVideo = projectShowVideo;
        this.projectDescribe = projectDescribe;
        this.showOrder = showOrder;
        this.status = status;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public ProjectinfoDomain() {
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
     * 所属分类
     * @return BelongCategory 所属分类
     */
    public String getBelongCategory() {
        return belongCategory;
    }

    /**
     * 所属分类
     * @param belongCategory 所属分类
     */
    public void setBelongCategory(String belongCategory) {
        this.belongCategory = belongCategory == null ? null : belongCategory.trim();
    }

    /**
     * 项目部名称
     * @return ProjectSiteName 项目部名称
     */
    public String getProjectSiteName() {
        return projectSiteName;
    }

    /**
     * 项目部名称
     * @param projectSiteName 项目部名称
     */
    public void setProjectSiteName(String projectSiteName) {
        this.projectSiteName = projectSiteName == null ? null : projectSiteName.trim();
    }

    /**
     * 项目地点
     * @return ProjectAddress 项目地点
     */
    public String getProjectAddress() {
        return projectAddress;
    }

    /**
     * 项目地点
     * @param projectAddress 项目地点
     */
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    /**
     * 项目展示图（列表）
     * @return ProjectShowPic 项目展示图（列表）
     */
    public String getProjectShowPic() {
        return projectShowPic;
    }

    /**
     * 项目展示图（列表）
     * @param projectShowPic 项目展示图（列表）
     */
    public void setProjectShowPic(String projectShowPic) {
        this.projectShowPic = projectShowPic == null ? null : projectShowPic.trim();
    }

    /**
     * 项目视频
     * @return ProjectShowVideo 项目视频
     */
    public String getProjectShowVideo() {
        return projectShowVideo;
    }

    /**
     * 项目视频
     * @param projectShowVideo 项目视频
     */
    public void setProjectShowVideo(String projectShowVideo) {
        this.projectShowVideo = projectShowVideo == null ? null : projectShowVideo.trim();
    }

    /**
     * 项目描述
     * @return ProjectDescribe 项目描述
     */
    public String getProjectDescribe() {
        return projectDescribe;
    }

    /**
     * 项目描述
     * @param projectDescribe 项目描述
     */
    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe == null ? null : projectDescribe.trim();
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
     * 项目状态
     * @return Status 项目状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 项目状态
     * @param status 项目状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}