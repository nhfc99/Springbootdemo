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
@RequestMapping("/schedu")
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
        List<UserDO> userlist = userService.selectUsersByNDPidAndNPids(list, pidlist, null);
        return userlist;
    }

    @RequestMapping("/deal")
    @ResponseBody
    public Object getDatas() {
        // 清除结果库
        resultService.deleteAll();
        // 获取所有的节假日
        List<RestdayDO> restdays = restdayService.selectAll();

        // 开始日期
        DateTime startdateTime = new DateTime("2019-08-31", DatePattern.NORM_DATE_PATTERN);
        // 结束时间
        DateTime enddateTime = new DateTime("2020-01-15", DatePattern.NORM_DATE_PATTERN);

        DateTime nextdatetime = startdateTime;
        do {
            // 获得指定日期是星期几，1表示周日，2表示周一
            int week = DateUtil.dayOfWeek(nextdatetime);

            // 判断是否是节假日
            RestdayDO restdayDO = restdayService.haveDate(restdays, nextdatetime.toDateStr());

            // 先拿领导
            List<UserDO> leaders = userService.selectLeaders();
            UserDO leaderUser = null;
            if (restdayDO != null) {// 该日期是白班
                leaderUser = userService.randUserList(week, userService.getMinUserListByDay(leaders));
            } else {// 该日期是夜班
                leaderUser = userService.randUserList(week, userService.getMinUserListByNight(leaders));
            }

            // 再拿第一个辅导员
            List<Integer> list = new ArrayList<Integer>();
            list.add(leaderUser.getU_dpid());
            List<Integer> pidlist = new ArrayList<Integer>();
            pidlist.add(1);
            pidlist.add(2);
            List<UserDO> userlist = userService.selectUsersByNDPidAndNPids(list, pidlist, null);

            UserDO userDO1 = null;
            if (restdayDO != null) {// 该日期是白班
                userDO1 = userService.randUserList(week, userService.getMinUserListByDay(userlist));
            } else {// 该日期是夜班
                userDO1 = userService.randUserList(week, userService.getMinUserListByNight(userlist));
            }

            // 再拿第二个辅导员
            list.add(userDO1.getU_dpid());

            List<UserDO> userlist1 = userService.selectUsersByNDPidAndNPids(list, pidlist, null);
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
        return "处理完成";
    }

    @RequestMapping("/dealnumber")
    @ResponseBody
    public Object getDatas1() {
        // 清除结果库
        resultService.deleteAll();
        // 获取所有的节假日
        List<RestdayDO> restdays = restdayService.selectAll();

        // 将这三个人存储到result表中
        ResultDO resultDO = new ResultDO();
        // 开始日期
        DateTime startdateTime = new DateTime("2019-09-09", DatePattern.NORM_DATE_PATTERN);
        // 结束时间
        DateTime enddateTime = new DateTime("2020-01-15", DatePattern.NORM_DATE_PATTERN);

        DateTime nextdatetime = startdateTime;
        do {
            List<Integer> userIds = new ArrayList<Integer>();

            // 如果存在之前的记录的时候，将这几个用户的id加入进去
            if (resultDO.getR_date() != null) {
                userIds.add(resultDO.getR_dpuid());
                userIds.add(resultDO.getR_fid1());
                userIds.add(resultDO.getR_fid2());
            }

            // 获得指定日期是星期几，1表示周日，2表示周一
            int week = DateUtil.dayOfWeek(nextdatetime);

            // 判断是否是节假日
            RestdayDO restdayDO = restdayService.haveDate(restdays, nextdatetime.toDateStr());

            // 先拿领导
            List<UserDO> leaders = userService.selectLeaders(userIds);
            UserDO leaderUser = null;
            if (restdayDO != null) {// 该日期是白班
                leaderUser = userService.randUserList(week, userService.getMinUserListByDay(leaders, null, null));
            } else {// 该日期是夜班
                leaderUser = userService.randUserList(week, userService.getMinUserListByNight(leaders, null, null));
            }

            // 再拿第一个辅导员
            List<Integer> list = new ArrayList<Integer>();
//			list.add(leaderUser.getU_dpid());
            List<Integer> pidlist = new ArrayList<Integer>();
            pidlist.add(1);
            pidlist.add(2);

            // 添加领导用户id
            userIds.add(leaderUser.getId());
            List<UserDO> userlist = userService.selectUsersByNDPidAndNPids(list, pidlist, userIds);

            UserDO userDO1 = null;
            if (restdayDO != null) {// 该日期是白班
                userDO1 = userService.randUserList(week,
                        userService.getMinUserListByDay(userlist, leaderUser.getU_dpid(), null));
            } else {// 该日期是夜班
                userDO1 = userService.randUserList(week,
                        userService.getMinUserListByNight(userlist, leaderUser.getU_dpid(), null));
            }

            // 再拿第二个辅导员
//			list.add(userDO1.getU_dpid());

            // 添加第一个辅导员id
            userIds.add(userDO1.getId());
            List<UserDO> userlist1 = userService.selectUsersByNDPidAndNPids(list, pidlist, userIds);
            UserDO userDO2 = null;
            if (restdayDO != null) {
                userDO2 = userService.randUserList(week,
                        userService.getMinUserListByDay(userlist1, leaderUser.getU_dpid(), userDO1.getU_dpid()));
            } else {
                userDO2 = userService.randUserList(week,
                        userService.getMinUserListByNight(userlist1, leaderUser.getU_dpid(), userDO1.getU_dpid()));
            }

            // 将这三个人存储到result表中
            resultDO.setR_date(nextdatetime.toDateStr()); // 设置日期
            resultDO.setR_dpuid(leaderUser.getId());// 领导id
            resultDO.setR_fid1(userDO1.getId());
            resultDO.setR_fid2(userDO2.getId());
            resultDO.setR_dutytype(restdayDO != null ? 1 : 2);
            resultService.insert(resultDO);

            // 下一天
            nextdatetime = DateUtil.offsetDay(nextdatetime, 1);
        } while (nextdatetime.compareTo(enddateTime) != 1);
        return "处理完成";
    }

    /**
     * 获取排班信息
     *
     * @return
     */
    @RequestMapping("/result")
    @ResponseBody
    public Object result() {
        List<ResultVO> resultVOsOs = resultService.selectResultAll();
        return resultVOsOs;
    }

    /**
     * 获取用户排班数量集合
     *
     * @return
     */
    @RequestMapping("/resultInfo")
    @ResponseBody
    public Object resultInfo() {
        return userService.resultInfo();
    }
}
