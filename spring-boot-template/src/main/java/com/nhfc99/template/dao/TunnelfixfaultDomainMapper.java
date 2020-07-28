package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunnelfixfaultDomain;

public interface TunnelfixfaultDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(TunnelfixfaultDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunnelfixfaultDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    TunnelfixfaultDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunnelfixfaultDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunnelfixfaultDomain record);
}