package com.nhfc99.duty.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.DepartmentDOMapper;
import com.nhfc99.duty.model.DepartmentDO;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDOMapper departmentDOMapper;

	private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

	public List<DepartmentDO> selectAll() {
		return departmentDOMapper.selectAll();
	}
}
