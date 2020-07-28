package com.nhfc99.template.dao;

import com.nhfc99.template.domain.SysmoduleDomain;

public interface SysmoduleDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(SysmoduleDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(SysmoduleDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    SysmoduleDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(SysmoduleDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(SysmoduleDomain record);
}