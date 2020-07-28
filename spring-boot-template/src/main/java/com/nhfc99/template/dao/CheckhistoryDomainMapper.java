package com.nhfc99.template.dao;

import com.nhfc99.template.domain.CheckhistoryDomain;

public interface CheckhistoryDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(CheckhistoryDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(CheckhistoryDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    CheckhistoryDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(CheckhistoryDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(CheckhistoryDomain record);
}