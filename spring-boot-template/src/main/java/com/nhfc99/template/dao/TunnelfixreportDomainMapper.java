package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunnelfixreportDomain;

public interface TunnelfixreportDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(TunnelfixreportDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunnelfixreportDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    TunnelfixreportDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunnelfixreportDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunnelfixreportDomain record);
}