package com.nhfc99.template.dao;

import com.nhfc99.template.domain.SysuserDomain;

public interface SysuserDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(SysuserDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(SysuserDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    SysuserDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(SysuserDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(SysuserDomain record);
}