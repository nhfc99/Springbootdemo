package com.nhfc99.template.service;

import com.nhfc99.template.dao.AttachfileDomainMapper;
import com.nhfc99.template.dao.TunnelinfoDomainMapper;
import com.nhfc99.template.dao.TunneltestfaultfixportDomainMapper;
import com.nhfc99.template.domain.AttachfileDomain;
import com.nhfc99.template.domain.TunnelinfoDomain;
import com.nhfc99.template.domain.TunneltestfaultfixportDomain;
import com.nhfc99.template.vo.ThirdTunnelInfoDefectsVo;
import com.nhfc99.template.vo.ThirdTunnelInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ThirdTunnelInfoService {
    @Autowired
    TunnelinfoDomainMapper tunnelinfoDomainMapper;

    @Autowired
    TunneltestfaultfixportDomainMapper tunneltestfaultfixportDomainMapper;

    @Autowired
    AttachfileDomainMapper attachfileDomainMapper;

    public ThirdTunnelInfoVo getThirdTunnelInfo(String data) {
        //隧道数据
        ArrayList<TunnelinfoDomain> tunnelinfoDomains = tunnelinfoDomainMapper.selectByTunnelName(data);
        if (tunnelinfoDomains.size() == 0) {
            return null;
        }
        TunnelinfoDomain tunnelinfoDomain = tunnelinfoDomains.get(0);
        //返回信息
        ThirdTunnelInfoVo thirdTunnelInfoVo = new ThirdTunnelInfoVo();
        thirdTunnelInfoVo.setId(tunnelinfoDomain.getId());
        thirdTunnelInfoVo.setName(tunnelinfoDomain.getTunnelName());
        thirdTunnelInfoVo.setAddress(tunnelinfoDomain.getBuildAddress());
        thirdTunnelInfoVo.setCode(tunnelinfoDomain.getPileNumCode());
        thirdTunnelInfoVo.setStartKM(tunnelinfoDomain.getStartKilometre());
        thirdTunnelInfoVo.setStartM(tunnelinfoDomain.getStartMetre());
        thirdTunnelInfoVo.setEndKM(tunnelinfoDomain.getEndKilometre());
        thirdTunnelInfoVo.setEndM(tunnelinfoDomain.getEndMetre());
        thirdTunnelInfoVo.setPlanLength(tunnelinfoDomain.getTunnelLength());
        thirdTunnelInfoVo.setBuildLength(tunnelinfoDomain.getBuildLength());
        thirdTunnelInfoVo.setCheckLength(tunnelinfoDomain.getTestLength());
        thirdTunnelInfoVo.setBetonLength(tunnelinfoDomain.getFixCrackLength());
        thirdTunnelInfoVo.setExplains(tunnelinfoDomain.getTunnelDescribe());

        ArrayList<TunneltestfaultfixportDomain> tunneltestfaultfixportDomainArrayList =
                tunneltestfaultfixportDomainMapper.selectByTunnelName(data);
        ArrayList<ThirdTunnelInfoDefectsVo> defects = new ArrayList<>();
        thirdTunnelInfoVo.setDefects(defects);
        Map<String, ThirdTunnelInfoDefectsVo> stringThirdTunnelInfoDefectsVoMap = new HashMap<>();
        ArrayList<String> dataInfoIds = new ArrayList<>();
        for (TunneltestfaultfixportDomain tunneltestfaultfixportDomain :
                tunneltestfaultfixportDomainArrayList) {
            String idString = tunneltestfaultfixportDomain.getId();
            ThirdTunnelInfoDefectsVo thirdTunnelInfoDefectsVo = null;
            if (stringThirdTunnelInfoDefectsVoMap.containsKey(idString)) {
                thirdTunnelInfoDefectsVo = stringThirdTunnelInfoDefectsVoMap.get(idString);
            } else {
                thirdTunnelInfoDefectsVo = new ThirdTunnelInfoDefectsVo();
                stringThirdTunnelInfoDefectsVoMap.put(idString, thirdTunnelInfoDefectsVo);
                thirdTunnelInfoDefectsVo.setId(tunneltestfaultfixportDomain.getId());
                thirdTunnelInfoDefectsVo.setReport(tunneltestfaultfixportDomain.getTunnelTestReportId());
                thirdTunnelInfoDefectsVo.setType(tunneltestfaultfixportDomain.getFaultType());
                thirdTunnelInfoDefectsVo.setPosition(tunneltestfaultfixportDomain.getFaultSite());
                thirdTunnelInfoDefectsVo.setStartKiloMetre(tunneltestfaultfixportDomain.getStartKilometre());
                thirdTunnelInfoDefectsVo.setStartMetre(tunneltestfaultfixportDomain.getStartMetre().doubleValue());
                thirdTunnelInfoDefectsVo.setLength(tunneltestfaultfixportDomain.getFaultLength().doubleValue());
                thirdTunnelInfoDefectsVo.setCheck(tunnelinfoDomain.getPileNumCode() +
                        tunnelinfoDomain.getStartKilometre() + tunnelinfoDomain.getStartMetre() +
                        "-"
                        + tunnelinfoDomain.getPileNumCode() +
                        tunnelinfoDomain.getEndKilometre() + tunnelinfoDomain.getEndMetre());
                thirdTunnelInfoDefectsVo.setInfo_01(tunneltestfaultfixportDomain.getDesignAmount());
                thirdTunnelInfoDefectsVo.setInfo_02(tunneltestfaultfixportDomain.getActualAmount());
                thirdTunnelInfoDefectsVo.setInfo_03(tunneltestfaultfixportDomain.getBackMemo());
                thirdTunnelInfoDefectsVo.setRepaired_Report(tunneltestfaultfixportDomain.getReportNum());
                thirdTunnelInfoDefectsVo.setReport_url(tunneltestfaultfixportDomain.getTestReportFile());
                thirdTunnelInfoDefectsVo.setRepaired_report_url(tunneltestfaultfixportDomain.getFixReportFile());
                ArrayList<String> arrayList = new ArrayList<>();
                thirdTunnelInfoDefectsVo.setImg(arrayList);

                ArrayList<String> repaired_img = new ArrayList<>();
                thirdTunnelInfoDefectsVo.setRepaired_img(repaired_img);

                //记忆修复报告id
                thirdTunnelInfoDefectsVo.setTunnelFixReportId(tunneltestfaultfixportDomain.getTunnelFixReportId());

                defects.add(thirdTunnelInfoDefectsVo);

                dataInfoIds.add(tunneltestfaultfixportDomain.getTunnelFixReportId());
            }
            ArrayList<String> images = thirdTunnelInfoDefectsVo.getImg();
            images.add(tunneltestfaultfixportDomain.getAttachUrl());
        }

        //整理修复报告的图片
        ArrayList<AttachfileDomain> attachfileDomains = new ArrayList<>();
        if (dataInfoIds.size() > 0) {
            attachfileDomains = attachfileDomainMapper.selectByDataInfoId(dataInfoIds);
        }
        Map<String, ArrayList<String>> stringArrayListMap = new HashMap<>();
        for (AttachfileDomain attachfileDomain:
             attachfileDomains) {
            String ids = attachfileDomain.getDataInfoId();
            ArrayList<String> strings = null;
            if (stringArrayListMap.containsKey(ids)) {
                strings = stringArrayListMap.get(ids);
            } else {
                strings = new ArrayList<>();
                stringArrayListMap.put(ids, strings);
            }
            strings.add(attachfileDomain.getAttachUrl());
        }

        //最后将修复报告的图片赋值进去即可
        ArrayList<String> tunnelFixReportIds = new ArrayList<>(stringArrayListMap.keySet());
        for (ThirdTunnelInfoDefectsVo thirdTunnelInfoDefectsVo :
                defects) {
            String tunnelFixReportId = thirdTunnelInfoDefectsVo.getTunnelFixReportId();
            if (tunnelFixReportIds.contains(tunnelFixReportId)) {
                thirdTunnelInfoDefectsVo.setRepaired_img(stringArrayListMap.get(tunnelFixReportId));
            }
        }

        return thirdTunnelInfoVo;
    }
}













