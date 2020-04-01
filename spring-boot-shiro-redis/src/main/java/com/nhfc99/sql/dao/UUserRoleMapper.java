package com.nhfc99.sql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.sql.model.UUserRole;

@Mapper
public interface UUserRoleMapper {
    int insert(UUserRole record);

    int insertSelective(UUserRole record);

    List<UUserRole> getUserRolesByUid(Long uid);
}