package com.nhfc99.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.sql.dao.UPermissionDOMapper;
import com.nhfc99.sql.model.UPermissionDO;

@Service
public class UPermissionService {
	@Autowired
	UPermissionDOMapper uPermissionDOMapper;

	public List<UPermissionDO> findPermissionByUid(Long id) {
		return uPermissionDOMapper.findPermissionByUid(id);
	}
}
