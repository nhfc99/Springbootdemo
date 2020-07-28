package com.nhfc99.template.service;

import com.nhfc99.template.component.redis.RedisUtil;
import com.nhfc99.template.dao.AreaprojectTunnelinfoTestfaultDomainMapper;
import com.nhfc99.template.dao.TestlinelengthgroupbyDomainMapper;
import com.nhfc99.template.dao.TunneltestlinedetailDomainMapper;
import com.nhfc99.template.domain.AreaprojectTunnelinfoTestfaultDomain;
import com.nhfc99.template.domain.TestlinelengthgroupbyDomain;
import com.nhfc99.template.pojo.DataCalculatDomain;
import com.nhfc99.template.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AreaprojecttunnelinfotestfaultService {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    AreaprojectTunnelinfoTestfaultDomainMapper areaprojectTunnelinfoTestfaultDomainMapper;
    @Autowired
    TunneltestlinedetailDomainMapper tunneltestlinedetailDomainMapper;
    @Autowired
    TestlinelengthgroupbyDomainMapper testlinelengthgroupbyDomainMapper;

    //类型：1.项目名称 2.隧道名称 3.全国区域 4.其他区域名称
    public ArrayList<AreaprojectTunnelinfoTestfaultDomain>
    getareaprojectTunnelinfoTestfaultDomainArrayList(int type, String data) {
        ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomainArrayList = null;
        switch (type) {
            case 1: {
                areaprojectTunnelinfoTestfaultDomainArrayList =
                        areaprojectTunnelinfoTestfaultDomainMapper.selectBy(data, null, null);
            }
            break;

            case 2: {
                areaprojectTunnelinfoTestfaultDomainArrayList =
                        areaprojectTunnelinfoTestfaultDomainMapper.selectBy(null, null, data);
            }
            break;

            case 3: {
                areaprojectTunnelinfoTestfaultDomainArrayList =
                        areaprojectTunnelinfoTestfaultDomainMapper.selectBy(null, null, null);
            }
            break;

            case 4: {
                areaprojectTunnelinfoTestfaultDomainArrayList =
                        areaprojectTunnelinfoTestfaultDomainMapper.selectBy(null, data, null);
            }
            break;
        }

        return areaprojectTunnelinfoTestfaultDomainArrayList;
    }

    //类型：1.项目名称 2.隧道名称 3.全国区域 4.其他区域名称 组织分散基础数据
    public DataCalculatDomain getDataCalculatDomain(ArrayList<AreaprojectTunnelinfoTestfaultDomain>
                                                            areaprojectTunnelinfoTestfaultDomainArrayList) {
        //记录隧道id
        ArrayList<String> tunnelIdMap = new ArrayList<>();
        DataCalculatDomain dataCalculatDomain = new DataCalculatDomain();
        for (AreaprojectTunnelinfoTestfaultDomain areaprojectTunnelinfoTestfaultDomain :
                areaprojectTunnelinfoTestfaultDomainArrayList) {
            //缺陷总长度faultLength
            dataCalculatDomain.setDefectLength(dataCalculatDomain.getDefectLength() +
                    areaprojectTunnelinfoTestfaultDomain.getFaultLength().doubleValue());
            // 缺陷总数defectCount
            dataCalculatDomain.setDefectCount(dataCalculatDomain.getDefectCount() + 1);
            //缺陷修复总数，计算方法：缺陷记录中标识为“已修复”的记录总数量tunneltestfault -> IsFix
            if (areaprojectTunnelinfoTestfaultDomain.getIsFix()) {
                dataCalculatDomain.setDefectrepairCount(dataCalculatDomain.getDefectrepairCount() + 1);
                dataCalculatDomain.setDefectrepairLength(dataCalculatDomain.getDefectrepairLength() +
                        areaprojectTunnelinfoTestfaultDomain.getFaultLength().longValue());
            }
            // 重大缺陷总数，计算方法：标识为“重大缺陷”的记录的数量tunneltestfault -> FaultLevel
            if (areaprojectTunnelinfoTestfaultDomain.getFaultLevel() == 4) {
                dataCalculatDomain.setKeyDefectCount(dataCalculatDomain.getKeyDefectCount() + 1);
                if (areaprojectTunnelinfoTestfaultDomain.getIsFix()) {
                    // 重大缺陷修复总数，计算方法：标识为“已修复”“重大缺陷”的记录数量tunneltestfault -> IsFix,FaultLevel
                    dataCalculatDomain.setKeyDefectRepairCount(dataCalculatDomain.getKeyDefectRepairCount() + 1);
                }
            }

            //记录隧道的所有id，按隧道分组
            if (!tunnelIdMap.contains(areaprojectTunnelinfoTestfaultDomain.getTunnelId())) {
                tunnelIdMap.add(areaprojectTunnelinfoTestfaultDomain.getTunnelId());

                // 规划隧道总长（KM），计算方法：相应隧道的规划长度合计      tunnelinfo -> TunnelLength
                dataCalculatDomain.setPlanLength(dataCalculatDomain.getPlanLength() +
                        areaprojectTunnelinfoTestfaultDomain.getTunnelLength().doubleValue());
                // 衬砌总长（KM） ，计算方法：相应隧道的已衬砌长度合计						tunnelinfo -> FixCrackLength
                dataCalculatDomain.setBetonLength(dataCalculatDomain.getBetonLength() +
                        areaprojectTunnelinfoTestfaultDomain.getFixCrackLength().doubleValue());
            }
        }
        // 总缺陷率（%）,计算方法：缺陷总长度 / 测线总长度 defectLength/checkLength
        if (tunnelIdMap.size() == 0) {
            return null;
        }
        ArrayList<TestlinelengthgroupbyDomain> testlinelengthgroupbyDomainArrayList =
                testlinelengthgroupbyDomainMapper.selectBy(tunnelIdMap);
        double cexianLength = 0.f;
        for (TestlinelengthgroupbyDomain testlinelengthgroupbyDomain : testlinelengthgroupbyDomainArrayList) {
            cexianLength += testlinelengthgroupbyDomain.getTestLineLength().doubleValue();
        }
        if (cexianLength > 0) {
            dataCalculatDomain.setDefectRate(dataCalculatDomain.getDefectLength() / cexianLength);
        }
        //测线总长
        dataCalculatDomain.setCheckLength(cexianLength);
        // 检测比率（%）     ，计算方法：测线总长度 / 相应的衬砌总长度   checkLength/betonLength
        if (dataCalculatDomain.getBetonLength() > 0) {
            dataCalculatDomain.setCheckRate(dataCalculatDomain.getCheckLength() / dataCalculatDomain.getBetonLength());
        }

        return dataCalculatDomain;
    }

    //获取types
    public Map<String, HomeQualityStatisticsTypesVo> getTypes(ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomainArrayList) {
        //type
        Map<String, HomeQualityStatisticsTypesVo> types = new HashMap<>();
        for (AreaprojectTunnelinfoTestfaultDomain areaprojectTunnelinfoTestfaultDomain :
                areaprojectTunnelinfoTestfaultDomainArrayList) {
            String faultType = areaprojectTunnelinfoTestfaultDomain.getFaultType();
            //types类型整合
            HomeQualityStatisticsTypesVo typeHomeQualityStatisticsTypesVo = null;
            if (types.containsKey(faultType)) {
                typeHomeQualityStatisticsTypesVo = types.get(faultType);
            } else {
                typeHomeQualityStatisticsTypesVo = new HomeQualityStatisticsTypesVo();
                types.put(faultType, typeHomeQualityStatisticsTypesVo);
            }
            if (areaprojectTunnelinfoTestfaultDomain.getIsFault()) {
                typeHomeQualityStatisticsTypesVo.setCount(typeHomeQualityStatisticsTypesVo.getCount() + 1);
                if (areaprojectTunnelinfoTestfaultDomain.getIsFix()) {
                    typeHomeQualityStatisticsTypesVo.setRepair(typeHomeQualityStatisticsTypesVo.getRepair() + 1);
                    //已修复长度
                    typeHomeQualityStatisticsTypesVo.setRepairlength(areaprojectTunnelinfoTestfaultDomain.getFaultLength().doubleValue());
                }
            }
            //缺陷总长度
            typeHomeQualityStatisticsTypesVo.setLength(typeHomeQualityStatisticsTypesVo.getLength() +
                    areaprojectTunnelinfoTestfaultDomain.getFaultLength().doubleValue());
        }
        return types;
    }

    String getKey(int type, String data, String funname) {
        String keyString = null;
        if (type == 3) {
            keyString = type + "all";
        } else {
            keyString = type + data;
        }
        keyString = funname + keyString;
        return keyString;
    }

    //类型：1.项目名称 2.隧道名称 3.全国区域 4.其他区域名称
    public HomeQualityStatisticsVo qualityStatistics(int type, String data) {
        if (type != 3 && data.length() == 0) {
            return null;
        }

        //检查缓存
        HomeQualityStatisticsVo homeQualityStatisticsVo = null;

        String keyString = getKey(type, data, "qualityStatistics");

        homeQualityStatisticsVo = (HomeQualityStatisticsVo) redisUtil.get(keyString);
        if (homeQualityStatisticsVo != null) {
            return homeQualityStatisticsVo;
        }

        homeQualityStatisticsVo = new HomeQualityStatisticsVo();

        ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomainArrayList =
                getareaprojectTunnelinfoTestfaultDomainArrayList(type, data);

        DataCalculatDomain dataCalculatDomain = getDataCalculatDomain(areaprojectTunnelinfoTestfaultDomainArrayList);
        if (dataCalculatDomain == null) {
            return null;
        }
        homeQualityStatisticsVo.defectLength = dataCalculatDomain.getDefectLength();
        homeQualityStatisticsVo.defectCount = dataCalculatDomain.getDefectCount();
        homeQualityStatisticsVo.defectRate = dataCalculatDomain.getDefectRate();
        homeQualityStatisticsVo.defectrepairCount = dataCalculatDomain.getDefectrepairCount();
        homeQualityStatisticsVo.keyDefectCount = dataCalculatDomain.getKeyDefectCount();
        homeQualityStatisticsVo.keyDefectRepairCount = dataCalculatDomain.getKeyDefectRepairCount();
        homeQualityStatisticsVo.planLength = dataCalculatDomain.getPlanLength();
        homeQualityStatisticsVo.betonLength = dataCalculatDomain.getBetonLength();
        homeQualityStatisticsVo.checkLength = dataCalculatDomain.getCheckLength();
        homeQualityStatisticsVo.checkRate = dataCalculatDomain.getCheckRate();

        //type
        Map<String, HomeQualityStatisticsTypesVo> types = new HashMap<>();
        //times
        Map<String, Map<String, Map<String, HomeQualityStatisticsTypesVo>>> times = new HashMap<>();
        for (AreaprojectTunnelinfoTestfaultDomain areaprojectTunnelinfoTestfaultDomain :
                areaprojectTunnelinfoTestfaultDomainArrayList) {
            String faultType = areaprojectTunnelinfoTestfaultDomain.getFaultType();
            HomeQualityStatisticsTypesVo homeQualityStatisticsTypesVo = types.get(faultType);
            if (homeQualityStatisticsTypesVo == null) {
                homeQualityStatisticsTypesVo = new HomeQualityStatisticsTypesVo();
            }
            homeQualityStatisticsTypesVo.count++;
            if (areaprojectTunnelinfoTestfaultDomain.getIsFix() == true) {
                homeQualityStatisticsTypesVo.repair++;
            }
            log.info("CreateDate = " + areaprojectTunnelinfoTestfaultDomain.getCreateDate());

            DateTime dateTime = new DateTime(areaprojectTunnelinfoTestfaultDomain.getCreateDate());
            String year = String.valueOf(dateTime.getYear());
            String month = String.valueOf(dateTime.getMonthOfYear());
            Map<String, Map<String, HomeQualityStatisticsTypesVo>> yearObject = null;
            Map<String, HomeQualityStatisticsTypesVo> monthObject = null;
            HomeQualityStatisticsTypesVo qualityStatisticsCountAndRepair = null;
            //年份
            if (times.containsKey(year)) {
                yearObject = times.get(year);
            } else {
                yearObject = new HashMap<>();
                times.put(year, yearObject);
            }
            //月份
            if (yearObject.containsKey(month)) {
                monthObject = yearObject.get(month);
            } else {
                monthObject = new HashMap<>();
                yearObject.put(month, monthObject);
            }
            //类型
            if (monthObject.containsKey(faultType)) {
                qualityStatisticsCountAndRepair = monthObject.get(faultType);
            } else {
                qualityStatisticsCountAndRepair = new HomeQualityStatisticsTypesVo();
                monthObject.put(faultType, qualityStatisticsCountAndRepair);
            }

            if (areaprojectTunnelinfoTestfaultDomain.getIsFault()) {
                qualityStatisticsCountAndRepair.setCount(qualityStatisticsCountAndRepair.getCount() + 1);
                if (areaprojectTunnelinfoTestfaultDomain.getIsFix()) {
                    qualityStatisticsCountAndRepair.setRepair(qualityStatisticsCountAndRepair.getRepair() + 1);
                }
            }

            //types类型整合
            HomeQualityStatisticsTypesVo typeHomeQualityStatisticsTypesVo = null;
            if (types.containsKey(faultType)) {
                typeHomeQualityStatisticsTypesVo = types.get(faultType);
                types.put(faultType, homeQualityStatisticsTypesVo);
            } else {
                typeHomeQualityStatisticsTypesVo = new HomeQualityStatisticsTypesVo();
                types.put(faultType, typeHomeQualityStatisticsTypesVo);
            }
            if (areaprojectTunnelinfoTestfaultDomain.getIsFault()) {
                typeHomeQualityStatisticsTypesVo.setCount(typeHomeQualityStatisticsTypesVo.getCount() + 1);
                if (areaprojectTunnelinfoTestfaultDomain.getIsFix()) {
                    typeHomeQualityStatisticsTypesVo.setRepair(typeHomeQualityStatisticsTypesVo.getRepair() + 1);
                }
            }
        }
        homeQualityStatisticsVo.types = types;
        homeQualityStatisticsVo.times = times;

        //缓存处理
        redisUtil.set(keyString, homeQualityStatisticsVo);

        return homeQualityStatisticsVo;
    }

    //类型：1.项目名称 2.隧道名称 3.全国区域 4.其他区域名称
    public HomeQualityStatisticsForAreaVo qualityStatisticsForArea(int type, String data) {
        if (type == 1) {
            type = 3;
        } else if (type == 2) {
            type = 4;
        } else {
            return null;
        }

        if (type == 4 &&
                data.length() == 0) {
            return null;
        }

        HomeQualityStatisticsForAreaVo homeQualityStatisticsForAreaVo = null;
        String keyString = getKey(type, data, "qualityStatisticsForArea");

        homeQualityStatisticsForAreaVo = (HomeQualityStatisticsForAreaVo) redisUtil.get(keyString);
        if (homeQualityStatisticsForAreaVo != null) {
            return homeQualityStatisticsForAreaVo;
        }

        homeQualityStatisticsForAreaVo = new HomeQualityStatisticsForAreaVo();

        ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomainArrayList =
                getareaprojectTunnelinfoTestfaultDomainArrayList(type, data);

        DataCalculatDomain dataCalculatDomain = getDataCalculatDomain(areaprojectTunnelinfoTestfaultDomainArrayList);
        if (dataCalculatDomain == null) {
            return null;
        }
        homeQualityStatisticsForAreaVo.defectLength = dataCalculatDomain.getDefectLength();
        homeQualityStatisticsForAreaVo.defectCount = dataCalculatDomain.getDefectCount();
        homeQualityStatisticsForAreaVo.defectRate = dataCalculatDomain.getDefectRate();
        homeQualityStatisticsForAreaVo.defectrepairCount = dataCalculatDomain.getDefectrepairCount();
        homeQualityStatisticsForAreaVo.keyDefectCount = dataCalculatDomain.getKeyDefectCount();
        homeQualityStatisticsForAreaVo.keyDefectRepairCount = dataCalculatDomain.getKeyDefectRepairCount();
        homeQualityStatisticsForAreaVo.planLength = dataCalculatDomain.getPlanLength();
        homeQualityStatisticsForAreaVo.betonLength = dataCalculatDomain.getBetonLength();
        homeQualityStatisticsForAreaVo.checkLength = dataCalculatDomain.getCheckLength();
        homeQualityStatisticsForAreaVo.checkRate = dataCalculatDomain.getCheckRate();
        homeQualityStatisticsForAreaVo.defectrepairLength = dataCalculatDomain.getDefectrepairLength();

        //type
        homeQualityStatisticsForAreaVo.types = getTypes(areaprojectTunnelinfoTestfaultDomainArrayList);

        //先对项目进行分组控制
        Map<String, ArrayList<AreaprojectTunnelinfoTestfaultDomain>> projectMap = new HashMap<>();
        for (AreaprojectTunnelinfoTestfaultDomain areaprojectTunnelinfoTestfaultDomain
                : areaprojectTunnelinfoTestfaultDomainArrayList) {
            String projectInfoId = areaprojectTunnelinfoTestfaultDomain.getProjectInfoId();
            ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomains = null;
            if (!projectMap.containsKey(projectInfoId)) {
                areaprojectTunnelinfoTestfaultDomains = new ArrayList<>();
                projectMap.put(projectInfoId, areaprojectTunnelinfoTestfaultDomains);
            } else {
                areaprojectTunnelinfoTestfaultDomains = projectMap.get(projectInfoId);
            }
            areaprojectTunnelinfoTestfaultDomains.add(areaprojectTunnelinfoTestfaultDomain);
        }

        Map<String, HomeQualityStatisticsForAreaProgramsVo> programs = new HashMap<>();

        //计算隧道项目数据
        ArrayList<String> projectMapKeys = new ArrayList<> (projectMap.keySet());
        for (String key :
                projectMapKeys) {
            ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomains =
                    projectMap.get(key);

            HomeQualityStatisticsForAreaProgramsVo homeQualityStatisticsForAreaProgramsVo = new HomeQualityStatisticsForAreaProgramsVo();

            dataCalculatDomain = getDataCalculatDomain(areaprojectTunnelinfoTestfaultDomains);
            if (dataCalculatDomain == null) {
                return null;
            }
            homeQualityStatisticsForAreaProgramsVo.defectLength = dataCalculatDomain.getDefectLength();
            homeQualityStatisticsForAreaProgramsVo.defectCount = dataCalculatDomain.getDefectCount();
            homeQualityStatisticsForAreaProgramsVo.defectRate = dataCalculatDomain.getDefectRate();
            homeQualityStatisticsForAreaProgramsVo.defectrepairCount = dataCalculatDomain.getDefectrepairCount();
            homeQualityStatisticsForAreaProgramsVo.keyDefectCount = dataCalculatDomain.getKeyDefectCount();
            homeQualityStatisticsForAreaProgramsVo.keyDefectRepairCount = dataCalculatDomain.getKeyDefectRepairCount();
            homeQualityStatisticsForAreaProgramsVo.betonLength = dataCalculatDomain.getBetonLength();
            homeQualityStatisticsForAreaProgramsVo.checkLength = dataCalculatDomain.getCheckLength();
            homeQualityStatisticsForAreaProgramsVo.planLength = dataCalculatDomain.getPlanLength();
            homeQualityStatisticsForAreaProgramsVo.defectrepairLength = dataCalculatDomain.getDefectrepairLength();

            homeQualityStatisticsForAreaProgramsVo.types = getTypes(areaprojectTunnelinfoTestfaultDomains);

            AreaprojectTunnelinfoTestfaultDomain areaprojectTunnelinfoTestfaultDomain =
                    areaprojectTunnelinfoTestfaultDomains.get(0);
            if (areaprojectTunnelinfoTestfaultDomain != null) {
                programs.put(areaprojectTunnelinfoTestfaultDomain.getProjectName(), homeQualityStatisticsForAreaProgramsVo);
            }
        }

        //programs
        homeQualityStatisticsForAreaVo.programs = programs;

        //缓存处理
        redisUtil.set(keyString, homeQualityStatisticsForAreaVo);

        return homeQualityStatisticsForAreaVo;
    }
}
















