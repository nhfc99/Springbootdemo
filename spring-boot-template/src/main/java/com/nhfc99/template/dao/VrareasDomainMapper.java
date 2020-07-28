package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VrareasDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface VrareasDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(VrareasDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(VrareasDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    VrareasDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有的
     * @return
     */
    ArrayList<VrareasDomain> selectAll();

    /**
     * 获取指定父id
     * @param id
     * @return
     */
    ArrayList<VrareasDomain> selectAllByParentid(Long id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(VrareasDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(VrareasDomain record);
}