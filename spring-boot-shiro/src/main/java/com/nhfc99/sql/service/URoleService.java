package com.nhfc99.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.sql.dao.URoleDOMapper;
import com.nhfc99.sql.model.URoleDO;

@Service
public class URoleService {
	@Autowired
	private URoleDOMapper uRoleDOMapper;

	public List<URoleDO> findRoleByUid(Long id) {
		return uRoleDOMapper.findRoleByUid(id);
	}
}
