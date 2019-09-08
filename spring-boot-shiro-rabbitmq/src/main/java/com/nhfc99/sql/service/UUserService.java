package com.nhfc99.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.sql.dao.UUserDOMapper;
import com.nhfc99.sql.model.UUserDO;

@Service
public class UUserService {
	@Autowired
	private UUserDOMapper userDOMapper;

	public UUserDO selectAllByName(String username) {
		return userDOMapper.selectAllByName(username);
	}
}
