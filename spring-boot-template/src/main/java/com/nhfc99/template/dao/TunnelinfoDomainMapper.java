package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunnelinfoDomain;
import com.nhfc99.template.pojo.ProgramsAndTunnelsSqlResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TunnelinfoDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(TunnelinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunnelinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    TunnelinfoDomain selectByPrimaryKey(String id);

    /**
     * 通过隧道名称获取隧道
     * @param tunnelName
     * @return
     */
    ArrayList<TunnelinfoDomain> selectByTunnelName(String tunnelName);

    /**
     * 检索数据
     * @return
     */
    ArrayList<ProgramsAndTunnelsSqlResult> selectProgramsAndTunnels();

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunnelinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunnelinfoDomain record);
}