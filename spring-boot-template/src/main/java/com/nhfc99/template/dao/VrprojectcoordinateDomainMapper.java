package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VrprojectcoordinateDomain;
import com.nhfc99.template.pojo.ProgramCoordinatesExtaDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface VrprojectcoordinateDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-30
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-30
     */
    int insert(VrprojectcoordinateDomain record);

    /**
     *
     * @mbggenerated 2020-05-30
     */
    int insertSelective(VrprojectcoordinateDomain record);

    /**
     *
     * @mbggenerated 2020-05-30
     */
    VrprojectcoordinateDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有数据
     * @return
     */
    ArrayList<ProgramCoordinatesExtaDomain> selectAllExtaDomain();

    /**
     *
     * @mbggenerated 2020-05-30
     */
    int updateByPrimaryKeySelective(VrprojectcoordinateDomain record);

    /**
     *
     * @mbggenerated 2020-05-30
     */
    int updateByPrimaryKey(VrprojectcoordinateDomain record);
}