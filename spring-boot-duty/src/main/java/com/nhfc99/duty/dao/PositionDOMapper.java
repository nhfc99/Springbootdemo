package com.nhfc99.duty.dao;

import com.nhfc99.duty.model.PositionDO;

public interface PositionDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PositionDO record);

    int insertSelective(PositionDO record);

    PositionDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PositionDO record);

    int updateByPrimaryKey(PositionDO record);
}