package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TestingbaseDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TestingbaseDomainMapper {
    /**
     *
     * @mbggenerated 2020-07-09
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-07-09
     */
    int insert(TestingbaseDomain record);

    /**
     *
     * @mbggenerated 2020-07-09
     */
    int insertSelective(TestingbaseDomain record);

    /**
     *
     * @mbggenerated 2020-07-09
     */
    TestingbaseDomain selectByPrimaryKey(Long id);

    /**
     * 通过标题获取数据
     * @param title
     * @return
     */
    TestingbaseDomain selectByTitle(String title);

    /**
     * 获取所有的数据
     * @return
     */
    ArrayList<TestingbaseDomain> selectAll();

    /**
     *
     * @mbggenerated 2020-07-09
     */
    int updateByPrimaryKeySelective(TestingbaseDomain record);

    /**
     *
     * @mbggenerated 2020-07-09
     */
    int updateByPrimaryKeyWithBLOBs(TestingbaseDomain record);

    /**
     *
     * @mbggenerated 2020-07-09
     */
    int updateByPrimaryKey(TestingbaseDomain record);
}