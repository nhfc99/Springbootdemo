package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VrequipmentsDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface VrequipmentsDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(VrequipmentsDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(VrequipmentsDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    VrequipmentsDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有的
     * @return
     */
    ArrayList<VrequipmentsDomain> selectAll();

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(VrequipmentsDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(VrequipmentsDomain record);
}