package com.nhfc99.duty.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.ResultDOMapper;
import com.nhfc99.duty.model.ResultDO;

@Service
public class ResultService {
	@Autowired
	ResultDOMapper resultDOMapper;

	public List<ResultDO> selectAll() {
		return resultDOMapper.selectAll();
	}

	public int selectCountBy(Integer uid, Integer rtype) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("uid", uid);
		params.put("rtype", rtype);
		return resultDOMapper.selectCountBy(params);
	}

	public void insert(ResultDO record) {
		resultDOMapper.insert(record);
	}

	public void deleteAll() {
		resultDOMapper.deleteAll();
	}
}
