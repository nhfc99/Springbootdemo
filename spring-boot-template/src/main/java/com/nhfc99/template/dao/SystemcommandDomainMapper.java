package com.nhfc99.template.dao;

import com.nhfc99.template.domain.SystemcommandDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface SystemcommandDomainMapper {
    /**
     *
     * @mbggenerated 2020-06-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int insert(SystemcommandDomain record);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int insertSelective(SystemcommandDomain record);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    SystemcommandDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有的内部指令
     * @return
     */
    ArrayList<SystemcommandDomain> selectAll();

    /**
     * 通过id或name获取指令
     * @return
     */
    ArrayList<SystemcommandDomain> selectBy(Long id, String value);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int updateByPrimaryKeySelective(SystemcommandDomain record);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int updateByPrimaryKey(SystemcommandDomain record);
}