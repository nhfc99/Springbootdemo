package com.nhfc99.template.service;

import com.nhfc99.template.dao.UserMapper;
import com.nhfc99.template.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }
}
