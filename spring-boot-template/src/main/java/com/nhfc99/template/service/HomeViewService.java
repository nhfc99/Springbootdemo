package com.nhfc99.template.service;

import com.nhfc99.template.component.redis.RedisUtil;
import com.nhfc99.template.dao.*;
import com.nhfc99.template.domain.*;
import com.nhfc99.template.pojo.*;
import com.nhfc99.template.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class HomeViewService {
    @Autowired
    VrareasDomainMapper vrareasDomainMapper;

    @Autowired
    VrequipmentsDomainMapper vrequipmentsDomainMapper;

    @Autowired
    VrhonoursDomainMapper vrhonoursDomainMapper;

    @Autowired
    VrkeyworksDomainMapper vrkeyworksDomainMapper;

    @Autowired
    VrstaffDomainMapper vrstaffDomainMapper;

    @Autowired
    VrtestcenterbaseinfoDomainMapper vrtestcenterbaseinfoDomainMapper;

    @Autowired
    ProjectinfoDomainMapper projectinfoDomainMapper;

    @Autowired
    TunnelinfoDomainMapper tunnelinfoDomainMapper;

    @Autowired
    ProjectareaDomainMapper projectareaDomainMapper;

    @Autowired
    VrprojectcoordinateDomainMapper rrprojectcoordinateDomainMapper;

    @Autowired
    TunneltestfaultDomainMapper tunneltestfaultDomainMapper;

    @Autowired
    HomeQualityStatisticsAllAreaDomainMapper homeQualityStatisticsAllAreaDomainMapper;

    @Autowired
    RedisUtil redisUtil;

    public HomeTestingCenterVo getData() {
        HomeTestingCenterVo homeTestingCenterVo = new HomeTestingCenterVo();

        VrtestcenterbaseinfoDomain vrtestcenterbaseinfoDomain = vrtestcenterbaseinfoDomainMapper.selectByPrimaryKey(1L);
        homeTestingCenterVo.name = vrtestcenterbaseinfoDomain.getName();
        homeTestingCenterVo.logo = vrtestcenterbaseinfoDomain.getLogo();
        homeTestingCenterVo.description = vrtestcenterbaseinfoDomain.getDescription();

        ArrayList<HomeUrlVo> list = new ArrayList();
        String[] urlList = vrtestcenterbaseinfoDomain.getVideos().split(";");
        for (int i = 0; i < urlList.length; i++) {
            HomeUrlVo homeUrlVo = new HomeUrlVo();
            homeUrlVo.url = urlList[i];
            list.add(homeUrlVo);
        }
        homeTestingCenterVo.videos = list;
        homeTestingCenterVo.keyWorks = vrkeyworksDomainMapper.selectAll();
        homeTestingCenterVo.honours = vrhonoursDomainMapper.selectAll();

        ArrayList<VrareasDomain> vrareasDomainArrayListAll = vrareasDomainMapper.selectAll();
        Map<Long, VrareasDomain> areaMap = new HashMap<>();
        for (VrareasDomain vrareasDomain : vrareasDomainArrayListAll) {
            areaMap.put(vrareasDomain.getId(), vrareasDomain);
        }

        ArrayList<VrstaffExtaDomain> vrstaffDomainArrayListAll = vrstaffDomainMapper.selectAllExa();
        for (VrstaffExtaDomain vrstaffExtaDomain : vrstaffDomainArrayListAll) {
            Long key = vrstaffExtaDomain.getVrareasid();
            if (areaMap.containsKey(key)) {
                vrstaffExtaDomain.area = areaMap.get(key).getName();
            }
        }
        homeTestingCenterVo.staff = vrstaffDomainArrayListAll;

        HomeEquipmentsVo homeEquipmentsVo = new HomeEquipmentsVo();
        ArrayList<VrequipmentsDomain> vrequipmentsDomainArrayList = vrequipmentsDomainMapper.selectAll();
        homeEquipmentsVo.equipments = vrequipmentsDomainArrayList;
        homeEquipmentsVo.count = homeEquipmentsVo.equipments.size();
        homeTestingCenterVo.equipments = homeEquipmentsVo;

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<VrareasDomain> vrareasDomainArrayList = vrareasDomainMapper.selectAllByParentid(0L);
        for (VrareasDomain vrareasDomain : vrareasDomainArrayList) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<VrareasDomain> vrareasDomainArrayListin = vrareasDomainMapper.selectAllByParentid(vrareasDomain.getId());
            for (VrareasDomain vrareasDomainin : vrareasDomainArrayListin) {
                arrayList.add(vrareasDomainin.getName());
            }
            map.put(vrareasDomain.getName(), arrayList);
        }
        homeTestingCenterVo.areas = map;

        return homeTestingCenterVo;
    }

    public ArrayList<HomeBenchmarkProjectVo> getBenchmarkProject() {
        ArrayList<HomeBenchmarkProjectVo> homeBenchmarkProjectVoArrayList = new ArrayList<>();
        ArrayList<ProjectinfoDomain> domainArrayList = projectinfoDomainMapper.selectAll();
        for (ProjectinfoDomain projectinfoDomain : domainArrayList) {
            HomeBenchmarkProjectVo homeBenchmarkProjectVo = new HomeBenchmarkProjectVo();
            homeBenchmarkProjectVo.img = projectinfoDomain.getProjectShowPic();
            homeBenchmarkProjectVo.name = projectinfoDomain.getProjectName();
            homeBenchmarkProjectVoArrayList.add(homeBenchmarkProjectVo);
        }
        return homeBenchmarkProjectVoArrayList;
    }

    public HomeProgramsAndTunnelsVo programsAndTunnels() {
        HomeProgramsAndTunnelsVo homeProgramsAndTunnelsVo = new HomeProgramsAndTunnelsVo();

        //先对类型进行分组
        ArrayList<ProgramsAndTunnelsSqlResult> railwayList = new ArrayList<>();
        ArrayList<ProgramsAndTunnelsSqlResult> highwayList = new ArrayList<>();
        ArrayList<ProgramsAndTunnelsSqlResult> subwaysList = new ArrayList<>();
        ArrayList<ProgramsAndTunnelsSqlResult> waterwayList = new ArrayList<>();

        List<String> list = Arrays.asList("铁路", "市政", "公路", "水利");
        ArrayList<ProgramsAndTunnelsSqlResult> programsAndTunnelsSqlResultArrayList = tunnelinfoDomainMapper.selectProgramsAndTunnels();
        homeProgramsAndTunnelsVo.tunnelCount = programsAndTunnelsSqlResultArrayList.size();//总隧道数量
        for (ProgramsAndTunnelsSqlResult programsAndTunnelsSqlResult : programsAndTunnelsSqlResultArrayList) {
            if (programsAndTunnelsSqlResult.BelongCategory.compareTo(list.get(0)) == 0) {//铁路
                railwayList.add(programsAndTunnelsSqlResult);
            } else if (programsAndTunnelsSqlResult.BelongCategory.compareTo(list.get(1)) == 0) {//市政
                highwayList.add(programsAndTunnelsSqlResult);
            } else if (programsAndTunnelsSqlResult.BelongCategory.compareTo(list.get(2)) == 0) {//公路
                subwaysList.add(programsAndTunnelsSqlResult);
            } else if (programsAndTunnelsSqlResult.BelongCategory.compareTo(list.get(3)) == 0) {//水利
                waterwayList.add(programsAndTunnelsSqlResult);
            }
        }

        homeProgramsAndTunnelsVo.railways = groupProjectType(railwayList);
        homeProgramsAndTunnelsVo.highways = groupProjectType(highwayList);
        homeProgramsAndTunnelsVo.subways = groupProjectType(subwaysList);
        homeProgramsAndTunnelsVo.waterways = groupProjectType(waterwayList);

        homeProgramsAndTunnelsVo.programCount += homeProgramsAndTunnelsVo.railways.programCount;
        homeProgramsAndTunnelsVo.programCount += homeProgramsAndTunnelsVo.highways.programCount;
        homeProgramsAndTunnelsVo.programCount += homeProgramsAndTunnelsVo.subways.programCount;
        homeProgramsAndTunnelsVo.programCount += homeProgramsAndTunnelsVo.waterways.programCount;

        return homeProgramsAndTunnelsVo;
    }

    //区域分组
    HomeProgramsAndTunnelsItemVo groupProjectType(ArrayList<ProgramsAndTunnelsSqlResult> list) {
        HomeProgramsAndTunnelsItemVo homeProgramsAndTunnelsItemVo = new HomeProgramsAndTunnelsItemVo();
        homeProgramsAndTunnelsItemVo.tunnelCount = list.size();

        //然后对类型内部的区域分组
        Map<String, ArrayList<ProgramsAndTunnelsSqlResult>> map = new HashMap<>();
        for (ProgramsAndTunnelsSqlResult programsAndTunnelsSqlResult : list) {
            ArrayList<ProgramsAndTunnelsSqlResult> programsAndTunnelsSqlResultArrayList = null;
            String key = programsAndTunnelsSqlResult.projectareaName;
            if (map.containsKey(key)) {
                programsAndTunnelsSqlResultArrayList = map.get(key);
            }
            if (programsAndTunnelsSqlResultArrayList == null) {
                programsAndTunnelsSqlResultArrayList = new ArrayList<ProgramsAndTunnelsSqlResult>();
                map.put(key, programsAndTunnelsSqlResultArrayList);
            }
            programsAndTunnelsSqlResultArrayList.add(programsAndTunnelsSqlResult);
        }

        //将分组后的ProgramsAndTunnelsSqlResult转化为HomeProgramsAndTunnelsItemAreaVo
        Map<String, HomeProgramsAndTunnelsItemAreaVo> maps = new HashMap<>();
        for (String key : map.keySet()) {
            ArrayList<ProgramsAndTunnelsSqlResult> arrayList = map.get(key);
            HomeProgramsAndTunnelsItemAreaVo homeProgramsAndTunnelsItemAreaVo = groupAreaProject(arrayList);
            maps.put(key, homeProgramsAndTunnelsItemAreaVo);

            //项目数量
            homeProgramsAndTunnelsItemVo.programCount += homeProgramsAndTunnelsItemAreaVo.programs.size();
        }
        homeProgramsAndTunnelsItemVo.areas = maps;

        return homeProgramsAndTunnelsItemVo;
    }

    //项目分组
    HomeProgramsAndTunnelsItemAreaVo groupAreaProject(ArrayList<ProgramsAndTunnelsSqlResult> list) {
        HomeProgramsAndTunnelsItemAreaVo homeProgramsAndTunnelsItemAreaVo = new HomeProgramsAndTunnelsItemAreaVo();
        homeProgramsAndTunnelsItemAreaVo.tunnelCount = list.size();

        //对项目进行分组
        Map<String, ArrayList<ProgramsAndTunnelsSqlResult>> map = new HashMap<>();
        for (ProgramsAndTunnelsSqlResult programsAndTunnelsSqlResult : list) {
            ArrayList<ProgramsAndTunnelsSqlResult> programsAndTunnelsSqlResultArrayList = null;
            String key = programsAndTunnelsSqlResult.ProjectName;
            if (map.containsKey(key)) {
                programsAndTunnelsSqlResultArrayList = map.get(key);
            }
            if (programsAndTunnelsSqlResultArrayList == null) {
                programsAndTunnelsSqlResultArrayList = new ArrayList<ProgramsAndTunnelsSqlResult>();
                map.put(key, programsAndTunnelsSqlResultArrayList);
            }
            programsAndTunnelsSqlResultArrayList.add(programsAndTunnelsSqlResult);
        }

        //将分组后的ProgramsAndTunnelsSqlResult转化为HomeProgramsAndTunnelsItemAreaProgramsVo
        Map<String, HomeProgramsAndTunnelsItemAreaProgramsVo> maps = new HashMap<>();
        for (String key : map.keySet()) {
            ArrayList<ProgramsAndTunnelsSqlResult> arrayList = map.get(key);
            maps.put(key, groupProject(arrayList));
        }
        homeProgramsAndTunnelsItemAreaVo.programs = maps;
        return homeProgramsAndTunnelsItemAreaVo;
    }

    //项目下隧道列表
    HomeProgramsAndTunnelsItemAreaProgramsVo groupProject(ArrayList<ProgramsAndTunnelsSqlResult> list) {
        HomeProgramsAndTunnelsItemAreaProgramsVo homeProgramsAndTunnelsItemAreaProgramsVo = new HomeProgramsAndTunnelsItemAreaProgramsVo();
        ArrayList<HomeProgramsAndTunnelsItemAreaProgramsTunnelsVo> arrayList = new ArrayList<>();
        for (ProgramsAndTunnelsSqlResult programsAndTunnelsSqlResult : list) {
            HomeProgramsAndTunnelsItemAreaProgramsTunnelsVo homeProgramsAndTunnelsItemAreaProgramsTunnelsVo = new HomeProgramsAndTunnelsItemAreaProgramsTunnelsVo();
            homeProgramsAndTunnelsItemAreaProgramsTunnelsVo.id = programsAndTunnelsSqlResult.tunnelinfoId;
            homeProgramsAndTunnelsItemAreaProgramsTunnelsVo.name = programsAndTunnelsSqlResult.TunnelName;
            arrayList.add(homeProgramsAndTunnelsItemAreaProgramsTunnelsVo);
        }

        if (list.size() > 0) {
            homeProgramsAndTunnelsItemAreaProgramsVo.id = list.get(0).projectinfoId;
        }
        homeProgramsAndTunnelsItemAreaProgramsVo.tunnels = arrayList;
        return homeProgramsAndTunnelsItemAreaProgramsVo;
    }

    //获取项目地图坐标
    public HomeProgramCoordinatesVo programCoordinates() {
        List<String> list = Arrays.asList("铁路", "市政", "公路", "水利");
        ArrayList<ProgramCoordinatesExtaDomain> projectinfoDomainArrayList = rrprojectcoordinateDomainMapper.selectAllExtaDomain();
        //先对类型进行分组
        ArrayList<ProgramCoordinatesExtaDomain> railwayList = new ArrayList<>();
        ArrayList<ProgramCoordinatesExtaDomain> highwayList = new ArrayList<>();
        ArrayList<ProgramCoordinatesExtaDomain> subwaysList = new ArrayList<>();
        ArrayList<ProgramCoordinatesExtaDomain> waterwayList = new ArrayList<>();

        for (ProgramCoordinatesExtaDomain programCoordinatesExtaDomain : projectinfoDomainArrayList) {
            String belongCategory = programCoordinatesExtaDomain.BelongCategory;
            if (belongCategory.compareTo(list.get(0)) == 0) {//铁路
                railwayList.add(programCoordinatesExtaDomain);
            } else if (belongCategory.compareTo(list.get(1)) == 0) {//市政
                highwayList.add(programCoordinatesExtaDomain);
            } else if (belongCategory.compareTo(list.get(2)) == 0) {//公路
                subwaysList.add(programCoordinatesExtaDomain);
            } else if (belongCategory.compareTo(list.get(3)) == 0) {//水利
                waterwayList.add(programCoordinatesExtaDomain);
            }
        }

        HomeProgramCoordinatesVo homeProgramCoordinatesVo = new HomeProgramCoordinatesVo();
        homeProgramCoordinatesVo.railways = mapArrayListHomeProgramCoordinatesVo(railwayList);
        homeProgramCoordinatesVo.highways = mapArrayListHomeProgramCoordinatesVo(highwayList);
        homeProgramCoordinatesVo.subways = mapArrayListHomeProgramCoordinatesVo(subwaysList);
        homeProgramCoordinatesVo.waterways = mapArrayListHomeProgramCoordinatesVo(waterwayList);

        return homeProgramCoordinatesVo;
    }

    //整理x和y
    Map<String, HomeProgramCoordinatesXYVo> mapArrayListHomeProgramCoordinatesVo(ArrayList<ProgramCoordinatesExtaDomain> arrayList) {
        Map<String, HomeProgramCoordinatesXYVo> hashMap = new HashMap<>();
        for (ProgramCoordinatesExtaDomain programCoordinatesExtaDomain : arrayList) {
            HomeProgramCoordinatesXYVo homeProgramCoordinatesXYVo = new HomeProgramCoordinatesXYVo();
            homeProgramCoordinatesXYVo.x = programCoordinatesExtaDomain.x;
            homeProgramCoordinatesXYVo.y = programCoordinatesExtaDomain.y;
            hashMap.put(programCoordinatesExtaDomain.ProjectName, homeProgramCoordinatesXYVo);
        }
        return hashMap;
    }

    //当前range范围内的隧道质量数据统计
    public HomeQualityStatisticsVo qualityStatistics(int type, String data) {
        String key = "qualityStatistics" + String.valueOf(type) + data;
        if (type == 3) {
            key = "qualityStatistics3";
        }
        if (redisUtil.hasKey(key)) {
            return (HomeQualityStatisticsVo) redisUtil.get(key);
        }

//        类型：1.项目名称 2.隧道名称 3.全国区域 4.其他区域名称
        HomeQualityStatisticsVo homeQualityStatisticsVo = new HomeQualityStatisticsVo();
        ArrayList<HomeQualityStatisticsAllAreaDomain> tunneltestfaultDomainArrayList = null;
        switch (type) {
            case 1: {
                tunneltestfaultDomainArrayList = tunneltestfaultDomainMapper.selectByProjectName(data);
            }
            break;

            case 2: {
                tunneltestfaultDomainArrayList = tunneltestfaultDomainMapper.selectByTunnelName(data);
            }
            break;

            case 3: {
                tunneltestfaultDomainArrayList = new ArrayList<HomeQualityStatisticsAllAreaDomain>();
                ArrayList<String> stringArrayList = new ArrayList<String>();
                ArrayList<ProjectareaDomain> projectareaDomainArrayList = projectareaDomainMapper.selectAll();
                for (ProjectareaDomain projectareaDomain :
                        projectareaDomainArrayList) {
                    stringArrayList.add(projectareaDomain.getName());
                }
                int page = 0;
                int pageSize = 100000;
                do {
                    ArrayList<HomeQualityStatisticsAllAreaDomain> list = homeQualityStatisticsAllAreaDomainMapper.selectByAreas(stringArrayList, page * pageSize, pageSize);
                    if (list.size() > 0) {
                        tunneltestfaultDomainArrayList.addAll(list);
                        page++;
                    } else {
                        break;
                    }
                } while (true);

            }
            break;

            case 4: {
                tunneltestfaultDomainArrayList = new ArrayList<HomeQualityStatisticsAllAreaDomain>();
                ArrayList<String> stringArrayList = new ArrayList<String>();
                stringArrayList.add(data);
                int page = 0;
                int pageSize = 100000;
                do {
                    ArrayList<HomeQualityStatisticsAllAreaDomain> list = homeQualityStatisticsAllAreaDomainMapper.selectByAreas(stringArrayList, page * pageSize, pageSize);
                    if (list.size() > 0) {
                        tunneltestfaultDomainArrayList.addAll(list);
                        page++;
                    } else {
                        break;
                    }
                } while (true);
            }
            break;
        }

        //时间数据和类型数据
        Map<String, HomeQualityStatisticsTypesVo> types = new HashMap<>();
        Map<String, Map<String, Map<String, HomeQualityStatisticsTypesVo>>> times = new HashMap<>();
        Map<String, TunneltestfaultCalculatModel> tunneltestfaultCalculatModelMap = new HashMap<>();
        for (HomeQualityStatisticsAllAreaDomain tunneltestfaultDomain :
                tunneltestfaultDomainArrayList) {
            if (tunneltestfaultDomain.getIsFault()) {
                homeQualityStatisticsVo.defectLength += tunneltestfaultDomain.getFaultLength().doubleValue();
                homeQualityStatisticsVo.defectCount++;
            }
            if (tunneltestfaultDomain.getIsFix()) {
                homeQualityStatisticsVo.defectrepairCount++;
            }

            if (tunneltestfaultDomain.getFaultLevel() == 4) {
                homeQualityStatisticsVo.keyDefectCount++;
            }

            if (tunneltestfaultDomain.getFaultLevel() == 4 && tunneltestfaultDomain.getIsFix()) {
                homeQualityStatisticsVo.keyDefectRepairCount++;
            }

            TunneltestfaultCalculatModel tunneltestfaultCalculatModel = null;
            if (!tunneltestfaultCalculatModelMap.containsKey(tunneltestfaultDomain.getTunnelInfoId())) {
                tunneltestfaultCalculatModel = new TunneltestfaultCalculatModel();
                tunneltestfaultCalculatModel.setPlanLength(tunneltestfaultDomain.getTunnelLength().doubleValue());
                tunneltestfaultCalculatModel.setBetonLength(tunneltestfaultDomain.getFixCrackLength().doubleValue());
                if (tunneltestfaultDomain.getTestLineLength() != null) {
                    homeQualityStatisticsVo.checkLength += tunneltestfaultDomain.getTestLineLength().doubleValue();
                }
                if (tunneltestfaultDomain.getTunnelLength() != null) {
                    homeQualityStatisticsVo.planLength += tunneltestfaultDomain.getTunnelLength().doubleValue();
                }
                if (tunneltestfaultDomain.getFixCrackLength() != null) {
                    homeQualityStatisticsVo.betonLength += tunneltestfaultDomain.getFixCrackLength().doubleValue();
                }

                tunneltestfaultCalculatModelMap.put(tunneltestfaultDomain.getTunnelInfoId(), tunneltestfaultCalculatModel);
            }

            DateTime dateTime = new DateTime(tunneltestfaultDomain.getCreateDate());
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
            String faultType = tunneltestfaultDomain.getFaultType();
            if (monthObject.containsKey(faultType)) {
                qualityStatisticsCountAndRepair = monthObject.get(faultType);
            } else {
                qualityStatisticsCountAndRepair = new HomeQualityStatisticsTypesVo();
                monthObject.put(faultType, qualityStatisticsCountAndRepair);
            }

            if (tunneltestfaultDomain.getIsFault()) {
                qualityStatisticsCountAndRepair.setCount(qualityStatisticsCountAndRepair.getCount() + 1);
                if (tunneltestfaultDomain.getIsFix()) {
                    qualityStatisticsCountAndRepair.setRepair(qualityStatisticsCountAndRepair.getRepair() + 1);
                }
            }

            //types类型整合
            HomeQualityStatisticsTypesVo typeHomeQualityStatisticsTypesVo = null;
            if (types.containsKey(faultType)) {
                typeHomeQualityStatisticsTypesVo = types.get(faultType);
            } else {
                typeHomeQualityStatisticsTypesVo = new HomeQualityStatisticsTypesVo();
                types.put(faultType, typeHomeQualityStatisticsTypesVo);
            }
            if (tunneltestfaultDomain.getIsFault()) {
                typeHomeQualityStatisticsTypesVo.setCount(typeHomeQualityStatisticsTypesVo.getCount() + 1);
                if (tunneltestfaultDomain.getIsFix()) {
                    typeHomeQualityStatisticsTypesVo.setRepair(typeHomeQualityStatisticsTypesVo.getRepair() + 1);
                }
            }
        }
        homeQualityStatisticsVo.times = times;
        homeQualityStatisticsVo.types = types;

        homeQualityStatisticsVo.defectLength = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.defectLength));
        homeQualityStatisticsVo.checkLength = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.checkLength));
        homeQualityStatisticsVo.defectRate = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.defectLength / homeQualityStatisticsVo.checkLength));
        homeQualityStatisticsVo.checkRate = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.checkLength / homeQualityStatisticsVo.betonLength));

        //redis缓存存储数据
        redisUtil.set(key, homeQualityStatisticsVo);

        return homeQualityStatisticsVo;
    }

    //当前range范围内的隧道质量数据统计 类型：1.全国区域 2.其他区域名称
    public HomeQualityStatisticsForAreaVo qualityStatisticsForArea(int type, String data) {
        String key = "qualityStatisticsForArea" + String.valueOf(type) + data;
        if (type == 1) {
            key = "qualityStatisticsForArea1";
        }
        if (redisUtil.hasKey(key)) {
            return (HomeQualityStatisticsForAreaVo) redisUtil.get(key);
        }

        HomeQualityStatisticsForAreaVo homeQualityStatisticsVo = new HomeQualityStatisticsForAreaVo();
        ArrayList<HomeQualityStatisticsAllAreaDomain> tunneltestfaultDomainArrayList = null;
        switch (type) {
            case 1: {
                tunneltestfaultDomainArrayList = new ArrayList<HomeQualityStatisticsAllAreaDomain>();
                ArrayList<String> stringArrayList = new ArrayList<String>();
                ArrayList<ProjectareaDomain> projectareaDomainArrayList = projectareaDomainMapper.selectAll();
                for (ProjectareaDomain projectareaDomain :
                        projectareaDomainArrayList) {
                    stringArrayList.add(projectareaDomain.getName());
                }
                int page = 0;
                int pageSize = 100000;
                do {
                    ArrayList<HomeQualityStatisticsAllAreaDomain> list = homeQualityStatisticsAllAreaDomainMapper.selectByAreas(stringArrayList, page * pageSize, pageSize);
                    if (list.size() > 0) {
                        tunneltestfaultDomainArrayList.addAll(list);
                        page++;
                    } else {
                        break;
                    }
                } while (true);

            }
            break;

            case 2: {
                tunneltestfaultDomainArrayList = new ArrayList<HomeQualityStatisticsAllAreaDomain>();
                ArrayList<String> stringArrayList = new ArrayList<String>();
                stringArrayList.add(data);
                int page = 0;
                int pageSize = 100000;
                do {
                    ArrayList<HomeQualityStatisticsAllAreaDomain> list = homeQualityStatisticsAllAreaDomainMapper.selectByAreas(stringArrayList, page * pageSize, pageSize);
                    if (list.size() > 0) {
                        tunneltestfaultDomainArrayList.addAll(list);
                        page++;
                    } else {
                        break;
                    }
                } while (true);
            }
            break;
        }

        //项目分组
        Map<String, ArrayList<HomeQualityStatisticsAllAreaDomain>> projectsMap = new HashMap<>();

        //时间数据和类型数据
        Map<String, HomeQualityStatisticsTypesVo> types = new HashMap<>();
        Map<String, TunneltestfaultCalculatModel> tunneltestfaultCalculatModelMap = new HashMap<>();
        for (HomeQualityStatisticsAllAreaDomain tunneltestfaultDomain :
                tunneltestfaultDomainArrayList) {
            if (tunneltestfaultDomain.getIsFault()) {
                homeQualityStatisticsVo.defectLength += tunneltestfaultDomain.getFaultLength().doubleValue();
                homeQualityStatisticsVo.defectCount++;
            }
            if (tunneltestfaultDomain.getIsFix()) {
                homeQualityStatisticsVo.defectrepairCount++;
            }

            if (tunneltestfaultDomain.getFaultLevel() == 4) {
                homeQualityStatisticsVo.keyDefectCount++;
            }

            if (tunneltestfaultDomain.getFaultLevel() == 4 && tunneltestfaultDomain.getIsFix()) {
                homeQualityStatisticsVo.keyDefectRepairCount++;
            }

            TunneltestfaultCalculatModel tunneltestfaultCalculatModel = null;
            if (!tunneltestfaultCalculatModelMap.containsKey(tunneltestfaultDomain.getTunnelInfoId())) {
                tunneltestfaultCalculatModel = new TunneltestfaultCalculatModel();
                if (tunneltestfaultDomain.getTestLineLength() != null) {
                    homeQualityStatisticsVo.checkLength += tunneltestfaultDomain.getTestLineLength().doubleValue();
                }
                if (tunneltestfaultDomain.getTunnelLength() != null) {
                    homeQualityStatisticsVo.planLength += tunneltestfaultDomain.getTunnelLength().doubleValue();
                }
                if (tunneltestfaultDomain.getFixCrackLength() != null) {
                    homeQualityStatisticsVo.betonLength += tunneltestfaultDomain.getFixCrackLength().doubleValue();
                }

                tunneltestfaultCalculatModelMap.put(tunneltestfaultDomain.getTunnelInfoId(), tunneltestfaultCalculatModel);
            }

            //类型
            String faultType = tunneltestfaultDomain.getFaultType();

            //types类型整合
            HomeQualityStatisticsTypesVo typeHomeQualityStatisticsTypesVo = null;
            if (types.containsKey(faultType)) {
                typeHomeQualityStatisticsTypesVo = types.get(faultType);
            } else {
                typeHomeQualityStatisticsTypesVo = new HomeQualityStatisticsTypesVo();
                types.put(faultType, typeHomeQualityStatisticsTypesVo);
            }
            if (tunneltestfaultDomain.getIsFault()) {
                typeHomeQualityStatisticsTypesVo.setCount(typeHomeQualityStatisticsTypesVo.getCount() + 1);
                if (tunneltestfaultDomain.getIsFix()) {
                    typeHomeQualityStatisticsTypesVo.setRepair(typeHomeQualityStatisticsTypesVo.getRepair() + 1);
                }
            }

            //项目分组
            String projectName = tunneltestfaultDomain.getProjectName();
            ArrayList<HomeQualityStatisticsAllAreaDomain> homeQualityStatisticsAllAreaDomainArrayList = null;
            if (projectsMap.containsKey(projectName)) {
                homeQualityStatisticsAllAreaDomainArrayList = projectsMap.get(projectName);
            } else {
                homeQualityStatisticsAllAreaDomainArrayList = new ArrayList<>();
                projectsMap.put(projectName, homeQualityStatisticsAllAreaDomainArrayList);
            }
            homeQualityStatisticsAllAreaDomainArrayList.add(tunneltestfaultDomain);
        }

        homeQualityStatisticsVo.types = types;

        homeQualityStatisticsVo.defectLength = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.defectLength));
        homeQualityStatisticsVo.checkLength = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.checkLength));
        homeQualityStatisticsVo.defectRate = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.defectLength / homeQualityStatisticsVo.checkLength));
        homeQualityStatisticsVo.checkRate = Double.valueOf(String.format("%.2f", homeQualityStatisticsVo.checkLength / homeQualityStatisticsVo.betonLength));

        //项目分组之后再进行分组数据处理
        Map<String, HomeQualityStatisticsForAreaProgramsVo> projectsOutMap = new HashMap<>();
        homeQualityStatisticsVo.programs = projectsOutMap;
        Set<String>set=projectsMap.keySet();
        for (String keyString : set) {
            ArrayList<HomeQualityStatisticsAllAreaDomain> list = projectsMap.get(keyString);

            HomeQualityStatisticsForAreaProgramsVo homeQualityStatisticsForAreaVo = new HomeQualityStatisticsForAreaProgramsVo();
            projectsOutMap.put(keyString, homeQualityStatisticsForAreaVo);
            Map<String, HomeQualityStatisticsTypesVo> typesMap = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                HomeQualityStatisticsAllAreaDomain tunneltestfaultDomain = list.get(j);

                if (tunneltestfaultDomain.getIsFault()) {
                    homeQualityStatisticsForAreaVo.defectLength += tunneltestfaultDomain.getFaultLength().doubleValue();
                    homeQualityStatisticsForAreaVo.defectCount++;
                }
                if (tunneltestfaultDomain.getIsFix()) {
                    homeQualityStatisticsForAreaVo.defectrepairCount++;
                }

                if (tunneltestfaultDomain.getFaultLevel() == 4) {
                    homeQualityStatisticsForAreaVo.keyDefectCount++;
                }

                if (tunneltestfaultDomain.getFaultLevel() == 4 && tunneltestfaultDomain.getIsFix()) {
                    homeQualityStatisticsForAreaVo.keyDefectRepairCount++;
                }

                //types类型整合
                String faultType = tunneltestfaultDomain.getFaultType();
                HomeQualityStatisticsTypesVo typeHomeQualityStatisticsTypesVo = null;
                if (typesMap.containsKey(faultType)) {
                    typeHomeQualityStatisticsTypesVo = typesMap.get(faultType);
                } else {
                    typeHomeQualityStatisticsTypesVo = new HomeQualityStatisticsTypesVo();
                    typesMap.put(faultType, typeHomeQualityStatisticsTypesVo);
                }
                if (tunneltestfaultDomain.getIsFault()) {
                    typeHomeQualityStatisticsTypesVo.setCount(typeHomeQualityStatisticsTypesVo.getCount() + 1);
                    if (tunneltestfaultDomain.getIsFix()) {
                        typeHomeQualityStatisticsTypesVo.setRepair(typeHomeQualityStatisticsTypesVo.getRepair() + 1);
                    }
                }
            }

            //最后补充只获取一次的数据
            if (list.size() > 0) {
                HomeQualityStatisticsAllAreaDomain tunneltestfaultDomain = list.get(0);
                if (tunneltestfaultDomain.getTestLineLength() != null) {
                    homeQualityStatisticsForAreaVo.checkLength += tunneltestfaultDomain.getTestLineLength().doubleValue();
                }
                if (tunneltestfaultDomain.getFixCrackLength() != null) {
                    homeQualityStatisticsForAreaVo.betonLength += tunneltestfaultDomain.getFixCrackLength().doubleValue();
                }
            }

            homeQualityStatisticsForAreaVo.types = typesMap;

            homeQualityStatisticsForAreaVo.defectLength = Double.valueOf(String.format("%.2f", homeQualityStatisticsForAreaVo.defectLength));
            homeQualityStatisticsForAreaVo.checkLength = Double.valueOf(String.format("%.2f", homeQualityStatisticsForAreaVo.checkLength));
            homeQualityStatisticsForAreaVo.defectRate = Double.valueOf(String.format("%.2f", homeQualityStatisticsForAreaVo.defectLength / homeQualityStatisticsForAreaVo.checkLength));
        }

        //redis缓存存储数据
        redisUtil.set(key, homeQualityStatisticsVo);

        return homeQualityStatisticsVo;
    }
}













