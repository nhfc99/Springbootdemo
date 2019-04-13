package com.nhfc99.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.nhfc99.test.domain.UserDO;

@Mapper
public interface UserDao {
	public int selectAllUser();
}
