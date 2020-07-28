package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VrkeyworksDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface VrkeyworksDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(VrkeyworksDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(VrkeyworksDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    VrkeyworksDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有的
     * @return
     */
    ArrayList<VrkeyworksDomain> selectAll();

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(VrkeyworksDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(VrkeyworksDomain record);
}