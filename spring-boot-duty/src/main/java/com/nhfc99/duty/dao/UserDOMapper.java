package com.nhfc99.duty.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nhfc99.duty.model.UserDO;

@Mapper
public interface UserDOMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserDO record);

	int insertSelective(UserDO record);

	UserDO selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserDO record);

	int updateByPrimaryKey(UserDO record);

	List<UserDO> selectAll();

	List<UserDO> selectUsersByPids(List<Integer> pids);
	
	List<UserDO> selectUsersByPidsExUids(Map<?, ?> map);

	List<UserDO> selectUsersByNDPidAndNPids(Map<?, ?> map);
}