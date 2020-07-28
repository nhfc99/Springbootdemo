package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class NewsdetailDomain implements Serializable {
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
     * 展示类型
     */
    private Integer showType;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 所属类别
     */
    private String newsClassId;

    /**
     * 新闻摘要
     */
    private String newsSummary;

    /**
     * 阅读次数
     */
    private Integer readCount;

    /**
     * 封面图片
     */
    private String coverPic;

    /**
     * 作者来源
     */
    private String newsSource;

    /**
     * 跳转链接
     */
    private String detailLink;

    /**
     * 视频地址
     */
    private String videoLink;

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
     * 状态
     */
    private Integer status;

    /**
     * 新闻详情
     */
    private String newsContent;

    /**
     * newsdetail
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public NewsdetailDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, Integer showType, String newsTitle, String newsClassId, String newsSummary, Integer readCount, String coverPic, String newsSource, String detailLink, String videoLink, String seoDescription, String seoKeywords, String seoTitle, Integer showOrder, Integer status, String newsContent) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.showType = showType;
        this.newsTitle = newsTitle;
        this.newsClassId = newsClassId;
        this.newsSummary = newsSummary;
        this.readCount = readCount;
        this.coverPic = coverPic;
        this.newsSource = newsSource;
        this.detailLink = detailLink;
        this.videoLink = videoLink;
        this.seoDescription = seoDescription;
        this.seoKeywords = seoKeywords;
        this.seoTitle = seoTitle;
        this.showOrder = showOrder;
        this.status = status;
        this.newsContent = newsContent;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public NewsdetailDomain() {
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
     * 展示类型
     * @return ShowType 展示类型
     */
    public Integer getShowType() {
        return showType;
    }

    /**
     * 展示类型
     * @param showType 展示类型
     */
    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    /**
     * 新闻标题
     * @return NewsTitle 新闻标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 新闻标题
     * @param newsTitle 新闻标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * 所属类别
     * @return NewsClassId 所属类别
     */
    public String getNewsClassId() {
        return newsClassId;
    }

    /**
     * 所属类别
     * @param newsClassId 所属类别
     */
    public void setNewsClassId(String newsClassId) {
        this.newsClassId = newsClassId == null ? null : newsClassId.trim();
    }

    /**
     * 新闻摘要
     * @return NewsSummary 新闻摘要
     */
    public String getNewsSummary() {
        return newsSummary;
    }

    /**
     * 新闻摘要
     * @param newsSummary 新闻摘要
     */
    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary == null ? null : newsSummary.trim();
    }

    /**
     * 阅读次数
     * @return ReadCount 阅读次数
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * 阅读次数
     * @param readCount 阅读次数
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
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
     * 作者来源
     * @return NewsSource 作者来源
     */
    public String getNewsSource() {
        return newsSource;
    }

    /**
     * 作者来源
     * @param newsSource 作者来源
     */
    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource == null ? null : newsSource.trim();
    }

    /**
     * 跳转链接
     * @return DetailLink 跳转链接
     */
    public String getDetailLink() {
        return detailLink;
    }

    /**
     * 跳转链接
     * @param detailLink 跳转链接
     */
    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink == null ? null : detailLink.trim();
    }

    /**
     * 视频地址
     * @return VideoLink 视频地址
     */
    public String getVideoLink() {
        return videoLink;
    }

    /**
     * 视频地址
     * @param videoLink 视频地址
     */
    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink == null ? null : videoLink.trim();
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
     * 状态
     * @return Status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 新闻详情
     * @return NewsContent 新闻详情
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 新闻详情
     * @param newsContent 新闻详情
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}