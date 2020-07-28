package com.nhfc99.template.dao;

import com.nhfc99.template.domain.SysmodulebuttonDomain;

public interface SysmodulebuttonDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(SysmodulebuttonDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(SysmodulebuttonDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    SysmodulebuttonDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(SysmodulebuttonDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(SysmodulebuttonDomain record);
}