package com.nhfc99.duty.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.duty.model.DepartmentDO;

@Mapper
public interface DepartmentDOMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(DepartmentDO record);

	int insertSelective(DepartmentDO record);

	DepartmentDO selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DepartmentDO record);

	int updateByPrimaryKey(DepartmentDO record);

	List<DepartmentDO> selectAll();
}