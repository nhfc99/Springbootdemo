package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VrstaffDomain;
import com.nhfc99.template.pojo.VrstaffExtaDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface VrstaffDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(VrstaffDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(VrstaffDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    VrstaffDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有的
     * @return
     */
    ArrayList<VrstaffDomain> selectAll();

    /**
     * 获取所有的
     * @return
     */
    ArrayList<VrstaffExtaDomain> selectAllExa();

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(VrstaffDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(VrstaffDomain record);
}