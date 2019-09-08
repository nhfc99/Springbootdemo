package com.nhfc99.duty.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.duty.model.SdutyDO;

@Mapper
public interface SdutyDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SdutyDO record);

    int insertSelective(SdutyDO record);

    SdutyDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SdutyDO record);

    int updateByPrimaryKey(SdutyDO record);
    
    List<SdutyDO> selectAll();
}