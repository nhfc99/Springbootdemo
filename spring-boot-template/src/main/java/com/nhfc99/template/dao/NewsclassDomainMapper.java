package com.nhfc99.template.dao;

import com.nhfc99.template.domain.NewsclassDomain;

public interface NewsclassDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(NewsclassDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(NewsclassDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    NewsclassDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(NewsclassDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(NewsclassDomain record);
}