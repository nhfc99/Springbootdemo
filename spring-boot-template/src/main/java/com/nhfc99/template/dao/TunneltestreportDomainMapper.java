package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunneltestreportDomain;

public interface TunneltestreportDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(TunneltestreportDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunneltestreportDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    TunneltestreportDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunneltestreportDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunneltestreportDomain record);
}