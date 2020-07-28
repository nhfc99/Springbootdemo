package com.nhfc99.template.dao;

import com.nhfc99.template.domain.NewsdetailDomain;

public interface NewsdetailDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(NewsdetailDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(NewsdetailDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    NewsdetailDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(NewsdetailDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeyWithBLOBs(NewsdetailDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(NewsdetailDomain record);
}