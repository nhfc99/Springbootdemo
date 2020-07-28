package com.nhfc99.template.dao;

import com.nhfc99.template.domain.ProjectinfoDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ProjectinfoDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(ProjectinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(ProjectinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    ProjectinfoDomain selectByPrimaryKey(String id);

    /**
     * 通过项目名称来获取
     * @param name
     * @return
     */
    ProjectinfoDomain selectByProjectName(String name);

    /**
     * 获取所有的项目
     * @return
     */
    ArrayList<ProjectinfoDomain> selectAll();

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(ProjectinfoDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(ProjectinfoDomain record);
}