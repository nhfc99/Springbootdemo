package com.nhfc99.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.nhfc99.test.domain.UserDO;

@Mapper
public interface UserDao {
    // 用户数量
    public int selectUserCount();

    // 获取所有的用户
    public List<UserDO> selectAllUser();
}
