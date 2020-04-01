package com.nhfc99.sql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.sql.model.URoleDO;

@Mapper
public interface URoleDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(URoleDO record);

    int insertSelective(URoleDO record);

    URoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(URoleDO record);

    int updateByPrimaryKey(URoleDO record);

    List<URoleDO> findRoleByUid(Long id);
}