package com.nhfc99.duty.dao;

import com.nhfc99.duty.model.RestdayDO;

public interface RestdayDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RestdayDO record);

    int insertSelective(RestdayDO record);

    RestdayDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RestdayDO record);

    int updateByPrimaryKey(RestdayDO record);
}