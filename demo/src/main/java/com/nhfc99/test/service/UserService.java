package com.nhfc99.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.test.dao.UserDao;
import com.nhfc99.test.domain.UserDO;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public int getAllUsers() {
		return userDao.selectAllUser();
	}
}
