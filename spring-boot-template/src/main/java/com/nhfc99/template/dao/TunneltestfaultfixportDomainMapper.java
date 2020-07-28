package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunneltestfaultfixportDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TunneltestfaultfixportDomainMapper {
    /**
     * @mbggenerated 2020-07-11
     */
    int insert(TunneltestfaultfixportDomain record);

    /**
     * @mbggenerated 2020-07-11
     */
    int insertSelective(TunneltestfaultfixportDomain record);

    /**
     * 通过隧道名称获取列表
     *
     * @param tunnelName
     * @return
     */
    ArrayList<TunneltestfaultfixportDomain> selectByTunnelName(String tunnelName);
}