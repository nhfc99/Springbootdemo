package com.nhfc99.duty.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.PositionDOMapper;
import com.nhfc99.duty.model.PositionDO;

@Service
public class PositionService {
	@Autowired
	PositionDOMapper positionDOMapper;

	private static final Logger log = LoggerFactory.getLogger(PositionService.class);

	public List<PositionDO> selectAll() {
		return positionDOMapper.selectAll();
	}
}
