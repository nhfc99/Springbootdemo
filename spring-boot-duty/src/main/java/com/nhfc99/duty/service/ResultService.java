package com.nhfc99.duty.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.ResultDOMapper;
import com.nhfc99.duty.model.DepartmentDO;
import com.nhfc99.duty.model.PositionDO;
import com.nhfc99.duty.model.ResultDO;
import com.nhfc99.duty.model.UserDO;
import com.nhfc99.duty.vo.ResultVO;

@Service
public class ResultService {
	@Autowired
	ResultDOMapper resultDOMapper;

	@Autowired
	UserService userService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	PositionService positionService;

	public List<ResultDO> selectAll() {
		return resultDOMapper.selectAll();
	}

	public List<ResultVO> selectResultAll() {
		List<UserDO> userDOs = userService.selectAll();
		List<DepartmentDO> departmentDOs = departmentService.selectAll();
		List<PositionDO> positionDOs = positionService.selectAll();
		List<ResultDO> list = selectAll();

		List<ResultVO> resultVOs = new ArrayList<ResultVO>();

		for (int i = 0; i < list.size(); i++) {
			ResultDO resultDO = list.get(i);

			ResultVO resultVO = new ResultVO();
			UserDO userDO = getUserDoBy(userDOs, resultDO.getR_dpuid());
			resultVO.setLusername(userDO.getU_name());
			resultVO.setLtelphone(userDO.getU_phone());
			resultVO.setLdepartment(getDepartmentDOBy(departmentDOs, userDO.getU_dpid()).getD_name());
			resultVO.setLposition(getPositionDOBy(positionDOs, userDO.getU_pid()).getName());

			userDO = getUserDoBy(userDOs, resultDO.getR_fid1());
			resultVO.setFusername(userDO.getU_name());
			resultVO.setFtelphone(userDO.getU_phone());
			resultVO.setFdepartment(getDepartmentDOBy(departmentDOs, userDO.getU_dpid()).getD_name());
			resultVO.setFposition(getPositionDOBy(positionDOs, userDO.getU_pid()).getName());

			userDO = getUserDoBy(userDOs, resultDO.getR_fid2());
			resultVO.setFfusername(userDO.getU_name());
			resultVO.setFftelphone(userDO.getU_phone());
			resultVO.setFfdepartment(getDepartmentDOBy(departmentDOs, userDO.getU_dpid()).getD_name());
			resultVO.setFfposition(getPositionDOBy(positionDOs, userDO.getU_pid()).getName());

			resultVOs.add(resultVO);
		}
		return resultVOs;
	}

	UserDO getUserDoBy(List<UserDO> userDOs, int uid) {
		for (int i = 0; i < userDOs.size(); i++) {
			UserDO userDO = userDOs.get(i);
			if (userDO.getId() == uid) {
				return userDO;
			}
		}
		return null;
	}

	DepartmentDO getDepartmentDOBy(List<DepartmentDO> departmentDOs, int did) {
		for (int i = 0; i < departmentDOs.size(); i++) {
			DepartmentDO departmentDO = departmentDOs.get(i);
			if (departmentDO.getId() == did) {
				return departmentDO;
			}
		}
		return null;
	}

	PositionDO getPositionDOBy(List<PositionDO> positionDOs, int pid) {
		for (int i = 0; i < positionDOs.size(); i++) {
			PositionDO positionDO = positionDOs.get(i);
			if (positionDO.getId() == pid) {
				return positionDO;
			}
		}
		return null;
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
