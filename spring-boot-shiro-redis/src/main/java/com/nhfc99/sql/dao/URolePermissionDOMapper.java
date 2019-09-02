package com.nhfc99.sql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.sql.model.URolePermissionDO;

@Mapper
public interface URolePermissionDOMapper {
    int insert(URolePermissionDO record);

    int insertSelective(URolePermissionDO record);
    
    List<URolePermissionDO> getRolePermissionsByrid(long rid);
}