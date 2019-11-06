package com.nhfc99.duty.dao;

import com.nhfc99.duty.model.ResultDO;

public interface ResultDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResultDO record);

    int insertSelective(ResultDO record);

    ResultDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResultDO record);

    int updateByPrimaryKey(ResultDO record);
}