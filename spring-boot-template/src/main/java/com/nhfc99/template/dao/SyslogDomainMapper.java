package com.nhfc99.template.dao;

import com.nhfc99.template.domain.SyslogDomain;

public interface SyslogDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(SyslogDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(SyslogDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    SyslogDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(SyslogDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(SyslogDomain record);
}