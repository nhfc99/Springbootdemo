package com.nhfc99.sql.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.sql.model.UUserDO;

@Mapper
public interface UUserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UUserDO record);

    int insertSelective(UUserDO record);

    UUserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUserDO record);

    int updateByPrimaryKey(UUserDO record);

    UUserDO selectAllByName(String username);
}