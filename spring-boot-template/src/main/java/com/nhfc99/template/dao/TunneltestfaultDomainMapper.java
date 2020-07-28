package com.nhfc99.template.dao;

import com.nhfc99.template.domain.HomeQualityStatisticsAllAreaDomain;
import com.nhfc99.template.domain.TunnelinfoDomain;
import com.nhfc99.template.domain.TunneltestfaultDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface TunneltestfaultDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(TunneltestfaultDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunneltestfaultDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    TunneltestfaultDomain selectByPrimaryKey(String id);

    /**
     * 通过隧道编号获取所有的缺陷信息
     * @return
     */
    ArrayList<TunneltestfaultDomain> selectAllByTunnelInfoId(ArrayList<String> tunnelInfoIds);

    /**
     * 通过项目名称获取所有的隧道列表
     * @param projectName
     * @return
     */
    ArrayList<HomeQualityStatisticsAllAreaDomain > selectByProjectName(String projectName);

    /**
     * 通过隧道名称获取隧道列表
     * @param tunnelName
     * @return
     */
    ArrayList<HomeQualityStatisticsAllAreaDomain > selectByTunnelName(String tunnelName);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunneltestfaultDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunneltestfaultDomain record);
}