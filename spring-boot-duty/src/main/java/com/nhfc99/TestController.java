package com.nhfc99;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nhfc99.duty.model.RestdayDO;
import com.nhfc99.duty.model.ResultDO;
import com.nhfc99.duty.model.UserDO;
import com.nhfc99.duty.service.DepartmentService;
import com.nhfc99.duty.service.PositionService;
import com.nhfc99.duty.service.RestdayService;
import com.nhfc99.duty.service.ResultService;
import com.nhfc99.duty.service.SdutyService;
import com.nhfc99.duty.service.UserService;
import com.nhfc99.duty.vo.ResultVO;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	UserService userService;
	@Autowired
	PositionService positionService;
	@Autowired
	RestdayService restdayService;
	@Autowired
	SdutyService sdutyService;
	@Autowired
	ResultService resultService;

	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/otest")
	@ResponseBody
	public Object list() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		List<Integer> pidlist = new ArrayList<Integer>();
		pidlist.add(3);
		pidlist.add(4);
		List<UserDO> userlist = userService.selectUsersByNDPidAndNPids(list, pidlist);
		return userlist;
	}

	@RequestMapping("/test")
	@ResponseBody
	public Object getDatas() {
		// 清除结果库
		resultService.deleteAll();
		// 获取所有的节假日
		List<RestdayDO> restdays = restdayService.selectAll();
		// 返回的结果集
//		List<ResultVO> resultVOs = new ArrayList<ResultVO>();

		// 开始日期
		DateTime startdateTime = new DateTime("2019-08-31", DatePattern.NORM_DATE_PATTERN);
		// 结束时间
//		DateTime enddateTime = new DateTime("2020-01-15", DatePattern.NORM_DATE_PATTERN);
		DateTime enddateTime = new DateTime("2020-09-3", DatePattern.NORM_DATE_PATTERN);
		DateTime nextdatetime = startdateTime;
		do {
			// 获得指定日期是星期几，1表示周日，2表示周一
			int week = DateUtil.dayOfWeek(nextdatetime);

			// 判断是否是节假日
			RestdayDO restdayDO = restdayService.haveDate(restdays, nextdatetime.toDateStr());

			// 先拿领导
			List<UserDO> leaders = userService.selectLeaders();
			UserDO leaderUser = userService.randUserList(week, userService.getMinUserListByDay(leaders));

			// 再拿第一个辅导员
			List<Integer> list = new ArrayList<Integer>();
			list.add(leaderUser.getU_dpid());
			List<Integer> pidlist = new ArrayList<Integer>();
			pidlist.add(1);
			pidlist.add(2);
			List<UserDO> userlist = userService.selectUsersByNDPidAndNPids(list, pidlist);

			UserDO userDO1 = null;
			if (restdayDO != null) {// 该日期是白班
				userDO1 = userService.randUserList(week, userService.getMinUserListByDay(userlist));
			} else {// 该日期是夜班
				userDO1 = userService.randUserList(week, userService.getMinUserListByNight(userlist));
			}

			// 再拿第二个辅导员
			list.add(userDO1.getU_dpid());

			List<UserDO> userlist1 = userService.selectUsersByNDPidAndNPids(list, pidlist);
			UserDO userDO2 = null;
			if (restdayDO != null) {
				userDO2 = userService.randUserList(week, userService.getMinUserListByDay(userlist1));
			} else {
				userDO2 = userService.randUserList(week, userService.getMinUserListByNight(userlist1));
			}

			// 将这三个人存储到result表中
			ResultDO resultDO = new ResultDO();
			resultDO.setR_date(nextdatetime.toDateStr()); // 设置日期
			resultDO.setR_dpuid(leaderUser.getId());// 领导id
			resultDO.setR_fid1(userDO1.getId());
			resultDO.setR_fid2(userDO2.getId());
			resultDO.setR_dutytype(restdayDO != null ? 1 : 2);
			resultService.insert(resultDO);

			// 下一天
			nextdatetime = DateUtil.offsetDay(nextdatetime, 1);
		} while (nextdatetime.compareTo(enddateTime) != 1);

		return "";
	}
}
