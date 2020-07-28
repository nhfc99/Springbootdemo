package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunnelfixcrackdetailDomain;

public interface TunnelfixcrackdetailDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(TunnelfixcrackdetailDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunnelfixcrackdetailDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    TunnelfixcrackdetailDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunnelfixcrackdetailDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunnelfixcrackdetailDomain record);
}