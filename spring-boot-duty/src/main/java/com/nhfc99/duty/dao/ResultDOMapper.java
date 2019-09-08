package com.nhfc99.duty.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.duty.model.ResultDO;

@Mapper
public interface ResultDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResultDO record);

    int insertSelective(ResultDO record);

    ResultDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResultDO record);

    int updateByPrimaryKey(ResultDO record);
    
    List<ResultDO> selectAll();
    
    int selectCountBy(Map<?, ?> map);
    
    void deleteAll();
}