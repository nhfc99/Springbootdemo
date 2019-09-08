package com.nhfc99.sql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.sql.dao.URoleDOMapper;
import com.nhfc99.sql.model.URoleDO;
import com.nhfc99.sql.model.UUserRole;

@Service
public class URoleService {
	@Autowired
	private URoleDOMapper uRoleDOMapper;

	@Autowired
	private UUserRoleService uUserRoleService;

	public List<URoleDO> findRoleByUid(long uid) {
		List<URoleDO> uRoleDOs = new ArrayList<>();
		List<UUserRole> list = uUserRoleService.getRolesByUid(uid);
		for (int i = 0; i < list.size(); i++) {
			UUserRole userRole = list.get(i);
			URoleDO uRoleDO = uRoleDOMapper.selectByPrimaryKey(userRole.getRid());
			uRoleDOs.add(uRoleDO);
		}
		return uRoleDOs;
	}
}
