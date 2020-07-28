package com.nhfc99.template.dao;

import com.nhfc99.template.domain.SysroleDomain;

public interface SysroleDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(SysroleDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(SysroleDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    SysroleDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(SysroleDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(SysroleDomain record);
}