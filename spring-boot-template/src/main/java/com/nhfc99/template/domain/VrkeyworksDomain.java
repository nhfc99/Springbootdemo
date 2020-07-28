package com.nhfc99.template.domain;

import java.io.Serializable;

public class VrkeyworksDomain implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * vrkeyworks
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrkeyworksDomain(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public VrkeyworksDomain() {
        super();
    }

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}