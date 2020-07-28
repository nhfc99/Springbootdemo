package com.nhfc99.template.dao;

import com.nhfc99.template.domain.MessageUserDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MessageUserDomainMapper {
    /**
     * @mbggenerated 2020-06-08
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbggenerated 2020-06-08
     */
    int insert(MessageUserDomain record);

    /**
     * @mbggenerated 2020-06-08
     */
    int insertSelective(MessageUserDomain record);

    /**
     * @mbggenerated 2020-06-08
     */
    MessageUserDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有的消息用户列表
     *
     * @return
     */
    ArrayList<MessageUserDomain> selectAll();

    /**
     * 获取指定用户id的列表
     *
     * @param arrayList
     * @return
     */
    ArrayList<MessageUserDomain> selectByIds(ArrayList<Long> arrayList);

    /**
     * @mbggenerated 2020-06-08
     */
    int updateByPrimaryKeySelective(MessageUserDomain record);

    /**
     * @mbggenerated 2020-06-08
     */
    int updateByPrimaryKey(MessageUserDomain record);
}