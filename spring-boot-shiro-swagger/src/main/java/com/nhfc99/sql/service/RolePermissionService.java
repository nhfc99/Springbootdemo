package com.nhfc99.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.sql.dao.URolePermissionDOMapper;
import com.nhfc99.sql.model.URolePermissionDO;

@Service
public class RolePermissionService {
	@Autowired
	URolePermissionDOMapper uRolePermissionDOMapper;

	List<URolePermissionDO> getRolePermissionsByRid(long rid) {
		return uRolePermissionDOMapper.getRolePermissionsByrid(rid);
	}
}
