package com.nhfc99.duty.dao;

import com.nhfc99.duty.model.DepartmentDO;

public interface DepartmentDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentDO record);

    int insertSelective(DepartmentDO record);

    DepartmentDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DepartmentDO record);

    int updateByPrimaryKey(DepartmentDO record);
}