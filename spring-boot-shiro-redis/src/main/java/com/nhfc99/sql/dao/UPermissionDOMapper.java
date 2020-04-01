package com.nhfc99.sql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.sql.model.UPermissionDO;

@Mapper
public interface UPermissionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UPermissionDO record);

    int insertSelective(UPermissionDO record);

    UPermissionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UPermissionDO record);

    int updateByPrimaryKey(UPermissionDO record);

    List<UPermissionDO> findPermissionByUid(Long id);
}