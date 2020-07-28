package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VrtestcenterbaseinfoDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VrtestcenterbaseinfoDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(VrtestcenterbaseinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(VrtestcenterbaseinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    VrtestcenterbaseinfoDomain selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(VrtestcenterbaseinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeyWithBLOBs(VrtestcenterbaseinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(VrtestcenterbaseinfoDomain record);
}