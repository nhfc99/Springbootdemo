package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VrhonoursDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface VrhonoursDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(VrhonoursDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(VrhonoursDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    VrhonoursDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有的
     * @return
     */
    ArrayList<VrhonoursDomain> selectAll();

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(VrhonoursDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(VrhonoursDomain record);
}