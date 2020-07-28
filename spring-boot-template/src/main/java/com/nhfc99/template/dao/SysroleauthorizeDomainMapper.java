package com.nhfc99.template.dao;

import com.nhfc99.template.domain.SysroleauthorizeDomain;

public interface SysroleauthorizeDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(SysroleauthorizeDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(SysroleauthorizeDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    SysroleauthorizeDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(SysroleauthorizeDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(SysroleauthorizeDomain record);
}