package com.nhfc99.sql.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.sql.model.UUserRole;

@Mapper
public interface UUserRoleMapper {
    int insert(UUserRole record);

    int insertSelective(UUserRole record);
}