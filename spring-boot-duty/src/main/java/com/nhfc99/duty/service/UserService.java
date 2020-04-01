package com.nhfc99.duty.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.DepartmentDOMapper;
import com.nhfc99.duty.dao.PositionDOMapper;
import com.nhfc99.duty.dao.UserDOMapper;
import com.nhfc99.duty.model.DepartmentDO;
import com.nhfc99.duty.model.PositionDO;
import com.nhfc99.duty.model.UserDO;
import com.nhfc99.duty.vo.UserResultInfoVO;

@Service
public class UserService {
    @Autowired
    UserDOMapper userDOMapper;
    @Autowired
    ResultService resultService;
    @Autowired
    PositionDOMapper positionDOMapper;
    @Autowired
    DepartmentDOMapper departmentDOMapper;

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

    public List<UserDO> selectLeaders(List<Integer> uids) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("list", list);
        params.put("uids", uids);

        List<UserDO> list2 = userDOMapper.selectUsersByPidsExUids(params);
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
    public List<UserDO> selectUsersByNDPidAndNPids(List<Integer> list, List<Integer> pidlist, List<Integer> uids) {
        Map<String, List<Integer>> params = new HashMap<String, List<Integer>>();
        params.put("list", list);
        params.put("pidlist", pidlist);
        params.put("uids", uids);
        List<UserDO> list2 = userDOMapper.selectUsersByNDPidAndNPids(params);
        return addOtherInfo(list2);
    }

    PositionDO getPosition(List<PositionDO> positionDOs, Integer id) {
        for (int i = 0; i < positionDOs.size(); i++) {
            PositionDO positionDO = positionDOs.get(i);
            if (positionDO.getId() == id) {
                return positionDO;
            }
        }
        return null;
    }

    DepartmentDO getDepartment(List<DepartmentDO> departmentDOs, Integer id) {
        for (int i = 0; i < departmentDOs.size(); i++) {
            DepartmentDO departmentDO = departmentDOs.get(i);
            if (departmentDO.getId() == id) {
                return departmentDO;
            }
        }
        return null;
    }

    /**
     * 获取用户的次数集合
     *
     * @return
     */
    public List<UserResultInfoVO> resultInfo() {
        List<PositionDO> positionDOs = positionDOMapper.selectAll();
        List<DepartmentDO> departmentDOs = departmentDOMapper.selectAll();

        List<UserResultInfoVO> resultInfoVOs = new ArrayList<UserResultInfoVO>();
        List<UserDO> userList = userDOMapper.selectAll();
        for (int i = 0; i < userList.size(); i++) {
            UserDO userDO = userList.get(i);
            userDO.setU_day(resultService.selectCountBy(userDO.getId(), 1));
            userDO.setU_night(resultService.selectCountBy(userDO.getId(), 2));

            UserResultInfoVO userResultInfoVO = new UserResultInfoVO();
            userResultInfoVO.setU_phone(userDO.getU_phone());
            userResultInfoVO.setU_name(userDO.getU_name());
            userResultInfoVO.setU_day(userDO.getU_day());
            userResultInfoVO.setU_night(userDO.getU_night());
            userResultInfoVO.setAllDays(userDO.getU_day() + userDO.getU_night());
            userResultInfoVO.setU_pname(getPosition(positionDOs, userDO.getU_pid()).getName());
            userResultInfoVO.setU_dpname(getDepartment(departmentDOs, userDO.getU_dpid()).getD_name());
            resultInfoVOs.add(userResultInfoVO);
        }
        return resultInfoVOs;
    }

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
     * @param excludeDP0 去掉第一个系别
     * @param excludeDP1 去掉第二个系别
     * @return
     */
    public List<UserDO> getMinUserListByDay(List<UserDO> list, Integer excludeDP0, Integer excludeDP1) {
        int min = list.get(0).getU_day() + list.get(0).getU_night();
        for (int i = 0; i < list.size(); i++) {
            UserDO userDO = list.get(i);
            int day = userDO.getU_day() + userDO.getU_night();
            min = Integer.min(min, day);
        }
        // 两个系都不为空
        List<UserDO> userList = getMinUserList(list, excludeDP0, excludeDP1, min, true);
        if (userList.size() > 0) {
            return userList;
        }

        // 一个系为空
        userList = getMinUserList(list, null, excludeDP1, min, true);
        if (userList.size() > 0) {
            return userList;
        }

        // 两个系为空
        userList = getMinUserList(list, null, null, min, true);
        if (userList.size() > 0) {
            return userList;
        }

        return userList;
    }

    public List<UserDO> getMinUserListByDay(List<UserDO> list) {
        int min = list.get(0).getU_day();
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

    List<UserDO> getMinUserList(List<UserDO> list, Integer excludeDP0, Integer excludeDP1, int min, Boolean day) {
        List<UserDO> userList = new ArrayList<UserDO>();
        for (int i = 0; i < list.size(); i++) {
            UserDO userDO = list.get(i);
            Boolean result = !(userDO.getU_dpid() == excludeDP0 || userDO.getU_dpid() == excludeDP0);
            if (day) {// 白班
                if (userDO.getU_day() == min) {
                    if (result) {
                        userList.add(userDO);
                    }
                }
            } else {// 夜班
                if (userDO.getU_night() == min) {
                    if (result) {
                        userList.add(userDO);
                    }
                }
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
    public List<UserDO> getMinUserListByNight(List<UserDO> list, Integer excludeDP0, Integer excludeDP1) {
        int min = list.get(0).getU_night() + list.get(0).getU_day();
        for (int i = 0; i < list.size(); i++) {
            UserDO userDO = list.get(i);
            int night = userDO.getU_night() + userDO.getU_day();
            min = Integer.min(min, night);
        }

        // 两个系都不为空
        List<UserDO> userList = getMinUserList(list, excludeDP0, excludeDP1, min, false);
        if (userList.size() > 0) {
            return userList;
        }

        // 一个系为空
        userList = getMinUserList(list, null, excludeDP1, min, false);
        if (userList.size() > 0) {
            return userList;
        }

        // 两个系为空
        userList = getMinUserList(list, null, null, min, false);
        if (userList.size() > 0) {
            return userList;
        }

        return userList;
    }

    public List<UserDO> getMinUserListByNight(List<UserDO> list) {
        int min = list.get(0).getU_night();
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
        if (list.size() == 0) {
            System.err.println("randUserList = 为0了");
        }

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
        // 筛选一个总排版最少的人
        if (list.size() == 0) {
            System.out.print("为0了");
        }

        Random rand = new Random();
        try {
            int number = rand.nextInt(list.size());
            return list.get(number);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("为0了");
        }
    }
}
