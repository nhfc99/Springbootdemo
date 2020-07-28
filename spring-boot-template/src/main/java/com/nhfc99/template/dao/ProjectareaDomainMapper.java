package com.nhfc99.template.dao;

import com.nhfc99.template.domain.ProjectareaDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ProjectareaDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(ProjectareaDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(ProjectareaDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    ProjectareaDomain selectByPrimaryKey(String id);

    /**
     * 获取所有的数据
     * @return
     */
    ArrayList<ProjectareaDomain> selectAll();

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(ProjectareaDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(ProjectareaDomain record);
}