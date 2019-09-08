package com.nhfc99.duty.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.duty.model.RestdayDO;

@Mapper
public interface RestdayDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RestdayDO record);

    int insertSelective(RestdayDO record);

    RestdayDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RestdayDO record);

    int updateByPrimaryKey(RestdayDO record);
    
    List<RestdayDO> selectAll();
}