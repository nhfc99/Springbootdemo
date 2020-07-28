package com.nhfc99.template.dao;

import com.nhfc99.template.domain.DeviceipinfoDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface DeviceipinfoDomainMapper {
    /**
     *
     * @mbggenerated 2020-06-13
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int insert(DeviceipinfoDomain record);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int insertSelective(DeviceipinfoDomain record);

    /**
     * 获取所有的IP列表
     * @return
     */
    ArrayList<DeviceipinfoDomain> selectAll();

    /**
     *
     * @mbggenerated 2020-06-13
     */
    DeviceipinfoDomain selectByPrimaryKey(Integer id);

    /**
     * 通过名称获取设备ip
     * @param name
     * @return
     */
    DeviceipinfoDomain selectByName(String name);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int updateByPrimaryKeySelective(DeviceipinfoDomain record);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int updateByPrimaryKey(DeviceipinfoDomain record);
}