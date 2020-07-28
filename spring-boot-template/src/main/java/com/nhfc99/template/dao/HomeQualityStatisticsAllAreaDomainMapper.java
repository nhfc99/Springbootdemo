package com.nhfc99.template.dao;

import com.nhfc99.template.domain.HomeQualityStatisticsAllAreaDomain;
import com.nhfc99.template.domain.TunneltestfaultDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface HomeQualityStatisticsAllAreaDomainMapper {
    /**
     *
     * @mbggenerated 2020-06-01
     */
    int insert(HomeQualityStatisticsAllAreaDomain record);

    /**
     *
     * @mbggenerated 2020-06-01
     */
    int insertSelective(HomeQualityStatisticsAllAreaDomain record);

    /**
     * 通过区域获取隧道列表
     * @param areas 使用都好分割
     * @return
     */
    ArrayList<HomeQualityStatisticsAllAreaDomain> selectByAreas(@Param("areas") ArrayList<String> areas, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 获取全国区域的隧道数据
     * @return
     */
    ArrayList<HomeQualityStatisticsAllAreaDomain> selectByAreasAll();
}