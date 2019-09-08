package com.nhfc99.duty.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.UserDOMapper;
import com.nhfc99.duty.model.UserDO;

@Service
public class UserService {
	@Autowired
	UserDOMapper userDOMapper;
	@Autowired
	ResultService resultService;

	public List<UserDO> selectAll() {
		return userDOMapper.selectAll();
	}

	public List<UserDO> selectLeaders() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		List<UserDO> list2 = userDOMapper.selectUsersByPids(list);
		return addOtherInfo(list2);
	}

	public List<UserDO> selectInstructors() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		List<UserDO> list2 = userDOMapper.selectUsersByPids(list);
		return addOtherInfo(list2);
	}

	/**
	 * 获取排除指定的职位和院系的人列表
	 * 
	 * @param list
	 * @param pidlist
	 * @return
	 */
	public List<UserDO> selectUsersByNDPidAndNPids(List<Integer> list, List<Integer> pidlist) {
		Map<String, List<Integer>> params = new HashMap<String, List<Integer>>();
		params.put("list", list);
		params.put("pidlist", pidlist);
		List<UserDO> list2 = userDOMapper.selectUsersByNDPidAndNPids(params);
		return addOtherInfo(list2);
	}

	/**
	 * 给每个用户计算加入白班和夜班次数的信息
	 * 
	 * @param list
	 * @return
	 */
	List<UserDO> addOtherInfo(List<UserDO> list) {
		for (int i = 0; i < list.size(); i++) {
			UserDO userDO = list.get(i);
			userDO.setU_day(resultService.selectCountBy(userDO.getId(), 1));
			userDO.setU_night(resultService.selectCountBy(userDO.getId(), 2));
		}
		return list;
	}

	/**
	 * 获取白天值班数量最少的人列表
	 * 
	 * @param list
	 * @return
	 */
	public List<UserDO> getMinUserListByDay(List<UserDO> list) {
		int min = 0;
		for (int i = 0; i < list.size(); i++) {
			UserDO userDO = list.get(i);
			int day = userDO.getU_day();
			min = Integer.min(min, day);
		}

		List<UserDO> userList = new ArrayList<UserDO>();
		for (int i = 0; i < list.size(); i++) {
			UserDO userDO = list.get(i);
			if (userDO.getU_day() == min) {
				userList.add(userDO);
			}
		}
		return userList;
	}

	/**
	 * 获取晚上值班数量最少的人列表
	 * 
	 * @param list
	 * @return
	 */
	public List<UserDO> getMinUserListByNight(List<UserDO> list) {
		int min = 0;
		for (int i = 0; i < list.size(); i++) {
			UserDO userDO = list.get(i);
			int night = userDO.getU_night();
			min = Integer.min(min, night);
		}

		List<UserDO> userList = new ArrayList<UserDO>();
		for (int i = 0; i < list.size(); i++) {
			UserDO userDO = list.get(i);
			if (userDO.getU_night() == min) {
				userList.add(userDO);
			}
		}
		return userList;
	}

	/**
	 * 得到某个用户
	 * 
	 * @param week 1表示周日，2表示周一
	 * @param list
	 * @return
	 */
	public UserDO randUserList(int week, List<UserDO> list) {
		System.err.println("randUserList = 为0了");
		
		// 62 - > 2/3/5
		UserDO userDO62 = null;
		// 1 -> 2
		UserDO userDO1 = null;

		// 筛选用户 邢淑芳尽量排在星期2/3/5，冯俊伶星期二
		if (week == 3 || week == 4 || week == 6) {
			for (int i = 0; i < list.size(); i++) {
				UserDO userDO = list.get(i);
				if (userDO.getId() == 1) {
					userDO1 = userDO;
				}

				if (userDO.getId() == 62) {
					userDO62 = userDO;
				}
			}

			List<UserDO> selectUser = new ArrayList<UserDO>();
			if (userDO62 != null) {
				selectUser.add(userDO62);
			}
			if (userDO1 != null) {
				selectUser.add(userDO1);
			}

			if (selectUser.size() > 0) {
				// 两个人都存在
				if (selectUser.size() == 2) {
					if (week == 3) {// 星期二
						return randUserBy(selectUser);
					} else {
						return userDO62;
					}
				} else {// 只存在一个人
					if (userDO1 != null) {// 1存在
						if (week == 3) {// 星期二
							return userDO1;
						} else {// 如果不是星期二，那么这个时候将该用户去除
							list.remove(userDO1);
						}
					} else {// 62存在
						return userDO62;
					}
				}
			}
		}

		// 如果上边的条件都不满足的情况下，拿其他用户
		return randUserBy(list);
	}

	/**
	 * 随机获取某个用户
	 * 
	 * @param list
	 * @return
	 */
	UserDO randUserBy(List<UserDO> list) {
		Random rand = new Random();
		int number = rand.nextInt(list.size());
		return list.get(number);
	}
}
