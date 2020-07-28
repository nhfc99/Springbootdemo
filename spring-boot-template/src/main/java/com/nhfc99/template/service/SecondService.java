package com.nhfc99.template.service;

import com.nhfc99.template.dao.ProjectinfoDomainMapper;
import com.nhfc99.template.dao.VrtestcenterbaseinfoDomainMapper;
import com.nhfc99.template.domain.AreaprojectTunnelinfoTestfaultDomain;
import com.nhfc99.template.domain.ProjectinfoDomain;
import com.nhfc99.template.domain.VrtestcenterbaseinfoDomain;
import com.nhfc99.template.pojo.DataCalculatDomain;
import com.nhfc99.template.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SecondService {
    @Autowired
    AreaprojecttunnelinfotestfaultService areaprojecttunnelinfotestfaultService;

    @Autowired
    ProjectinfoDomainMapper projectinfoDomainMapper;

    @Autowired
    VrtestcenterbaseinfoDomainMapper vrtestcenterbaseinfoDomainMapper;

    @Autowired
    TestingBaseService testingBaseService;

    public SecondProgramInfoVo getProgramInfo(String data) {
        SecondProgramInfoVo secondProgramInfoVo = new SecondProgramInfoVo();
        //先获取项目信息
        ProjectinfoDomain projectinfoDomain = projectinfoDomainMapper.selectByProjectName(data);
        if (projectinfoDomain == null) {
            return null;
        }

        secondProgramInfoVo.setId(projectinfoDomain.getId());
        secondProgramInfoVo.setName(projectinfoDomain.getProjectName());
        secondProgramInfoVo.setAddress(projectinfoDomain.getProjectAddress());
        secondProgramInfoVo.setDepartment(projectinfoDomain.getProjectSiteName());
        if (projectinfoDomain.getProjectShowVideo() != null) {
            String[] strings = projectinfoDomain.getProjectShowVideo().split(";");
            secondProgramInfoVo.setVideos(strings);
        }
        secondProgramInfoVo.setType(projectinfoDomain.getBelongCategory());
        secondProgramInfoVo.setExplains(projectinfoDomain.getProjectDescribe());

        //获取项目下边的隧道信息
        ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomainArrayList =
                areaprojecttunnelinfotestfaultService.getareaprojectTunnelinfoTestfaultDomainArrayList(1, data);
        //空数据
        if (areaprojectTunnelinfoTestfaultDomainArrayList.size() == 0) {
            return secondProgramInfoVo;
        }

        //对隧道进行分组处理
        Map<String, ArrayList<AreaprojectTunnelinfoTestfaultDomain>> stringArrayListMap = new HashMap<>();
        for (AreaprojectTunnelinfoTestfaultDomain areaprojectTunnelinfoTestfaultDomain :
                areaprojectTunnelinfoTestfaultDomainArrayList) {
            String tunnelId = areaprojectTunnelinfoTestfaultDomain.getTunnelId();

            //判断隧道id是否已经存储
            ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomains = null;
            if (stringArrayListMap.containsKey(tunnelId)) {
                areaprojectTunnelinfoTestfaultDomains = stringArrayListMap.get(tunnelId);
            } else {
                areaprojectTunnelinfoTestfaultDomains = new ArrayList<>();
                stringArrayListMap.put(tunnelId, areaprojectTunnelinfoTestfaultDomains);
            }
            areaprojectTunnelinfoTestfaultDomains.add(areaprojectTunnelinfoTestfaultDomain);
        }

        //整理隧道数据
        ArrayList<SecondProgramInfoTunnelsClass> tunnels = new ArrayList<>();
        List<String> keys = new ArrayList<>(stringArrayListMap.keySet()); //拿到所有隧道的key
        for (String keyString :
                keys) {
            SecondProgramInfoTunnelsClass secondProgramInfoTunnelsClass = new SecondProgramInfoTunnelsClass();
            //拿到隧道所有的检测报告
            ArrayList<AreaprojectTunnelinfoTestfaultDomain> areaprojectTunnelinfoTestfaultDomains =
                    stringArrayListMap.get(keyString);
            AreaprojectTunnelinfoTestfaultDomain areaprojectTunnelinfoTestfaultDomain =
                    areaprojectTunnelinfoTestfaultDomains.get(0);//拿到第一个报告，用于拿到隧道的基本信息
            secondProgramInfoTunnelsClass.setId(areaprojectTunnelinfoTestfaultDomain.getTunnelId());//隧道id
            secondProgramInfoTunnelsClass.setName(areaprojectTunnelinfoTestfaultDomain.getTunnelName());

            //计算各种率
            SecondProgramInfoTunnelsStatisticsClass qualityStatistics = new SecondProgramInfoTunnelsStatisticsClass();
            DataCalculatDomain dataCalculatDomain = areaprojecttunnelinfotestfaultService.
                    getDataCalculatDomain(areaprojectTunnelinfoTestfaultDomains);
            qualityStatistics.setCheckRate(dataCalculatDomain.getCheckRate());
            qualityStatistics.setDefectRate(dataCalculatDomain.getDefectRate());
            qualityStatistics.setDefectCount(dataCalculatDomain.getDefectCount());
            qualityStatistics.setDefectRepairCount(dataCalculatDomain.getDefectrepairCount());
            qualityStatistics.setDefectRepairRate(dataCalculatDomain.getDefectrepairCount() / dataCalculatDomain.getDefectCount());

            Map<String, HomeQualityStatisticsTypesVo> stringHomeQualityStatisticsTypesCXVoMap =
                    areaprojecttunnelinfotestfaultService.getTypes(areaprojectTunnelinfoTestfaultDomains);
            List<String> faultTypeKeys = new ArrayList<>(stringHomeQualityStatisticsTypesCXVoMap.keySet()); //拿到所有faultType
            Map<String, Double> defectRageTypes = new HashMap<>();//缺陷长度/测线总长度 = 缺陷率  总的
            Map<String, Double> defectRepairRateTypes = new HashMap<>();//整改合格率 = 修复长度/自己的缺陷长度 自己的
            double checkLength = dataCalculatDomain.getCheckLength();//测线总长度
            long allCount = 0;//总缺陷长度
            for (String faultTypeKey :
                    faultTypeKeys) {
                HomeQualityStatisticsTypesVo homeQualityStatisticsTypesVo =
                        stringHomeQualityStatisticsTypesCXVoMap.get(faultTypeKey);
                allCount += homeQualityStatisticsTypesVo.getCount();

                if (faultTypeKey.compareTo("混凝土强度") == 0) {
                    double count = homeQualityStatisticsTypesVo.getCount();
                    if (count > 0) {
                        defectRepairRateTypes.put(faultTypeKey, (homeQualityStatisticsTypesVo.getRepair() / count));
                    } else {
                        count = 0;
                        defectRepairRateTypes.put(faultTypeKey, count);
                    }
                } else {
                    double length = homeQualityStatisticsTypesVo.getLength();
                    if (length > 0) {
                        defectRepairRateTypes.put(faultTypeKey, (homeQualityStatisticsTypesVo.getRepairlength() / length));
                    } else {
                        double count = 0;
                        defectRepairRateTypes.put(faultTypeKey, count);
                    }
                }
            }

            for (String faultTypeKey :
                    faultTypeKeys) {
                HomeQualityStatisticsTypesVo homeQualityStatisticsTypesVo =
                        stringHomeQualityStatisticsTypesCXVoMap.get(faultTypeKey);
                if (faultTypeKey.compareTo("混凝土强度") == 0) {
                    double count = homeQualityStatisticsTypesVo.getCount();
                    if (count > 0) {
                        defectRageTypes.put(faultTypeKey, (homeQualityStatisticsTypesVo.getRepair() / count));
                    } else {
                        count = 0;
                        defectRageTypes.put(faultTypeKey, count);
                    }
                } else {
                    double count = 0;
                    if (checkLength > 0) {
                        defectRageTypes.put(faultTypeKey, (homeQualityStatisticsTypesVo.getLength() / checkLength));
                    } else {
                        count = 0;
                        defectRageTypes.put(faultTypeKey, count);
                    }
                }
            }

            //整改合格率
            qualityStatistics.setDefectRepairRateTypes(defectRepairRateTypes);

            //缺陷率
            qualityStatistics.setDefectRageTypes(defectRageTypes);

            secondProgramInfoTunnelsClass.setQualityStatistics(qualityStatistics);

            //增加隧道数据
            tunnels.add(secondProgramInfoTunnelsClass);
        }
        secondProgramInfoVo.setTunnels(tunnels);
        return secondProgramInfoVo;
    }

    public SecondTestingBaseVo getTestingBase() {
        SecondTestingBaseVo secondTestingBaseVo = new SecondTestingBaseVo();

        ArrayList<TestingbaseDomainAllVo> testingbaseDomainAllVoArrayList = testingBaseService.selectAll();
        secondTestingBaseVo.setPresetparts(testingbaseDomainAllVoArrayList);

        VrtestcenterbaseinfoDomain vrtestcenterbaseinfoDomain = vrtestcenterbaseinfoDomainMapper.selectByPrimaryKey((long) 1);
        if (vrtestcenterbaseinfoDomain != null) {
            secondTestingBaseVo.setName(vrtestcenterbaseinfoDomain.getName());
            secondTestingBaseVo.setDescription(vrtestcenterbaseinfoDomain.getDescription());

            ArrayList<Map<String, String>> videos = new ArrayList<>();
            if (vrtestcenterbaseinfoDomain.getVideos() != null) {
                String[] strings = vrtestcenterbaseinfoDomain.getVideos().split(";");
                for (String string :
                        strings) {
                    Map<String, String> stringStringMap = new HashMap<>();
                    stringStringMap.put("url", string);
                    videos.add(stringStringMap);
                }
                secondTestingBaseVo.setVideos(videos);
            }
        }
        return secondTestingBaseVo;
    }
}



















