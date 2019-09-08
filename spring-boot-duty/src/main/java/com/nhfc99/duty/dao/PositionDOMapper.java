package com.nhfc99.duty.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.duty.model.PositionDO;

@Mapper
public interface PositionDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PositionDO record);

    int insertSelective(PositionDO record);

    PositionDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PositionDO record);

    int updateByPrimaryKey(PositionDO record);
    
    List<PositionDO> selectAll();
}