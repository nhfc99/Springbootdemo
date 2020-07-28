package com.nhfc99.template.vo;

import com.nhfc99.template.domain.VrareasDomain;
import com.nhfc99.template.domain.VrhonoursDomain;
import com.nhfc99.template.domain.VrkeyworksDomain;
import com.nhfc99.template.domain.VrstaffDomain;
import com.nhfc99.template.pojo.VrstaffExtaDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

@Data
@ApiModel(value="工程检测中心基础信息",description="工程检测中心基础信息")
public class HomeTestingCenterVo {
    @ApiModelProperty(value="名称")
    public String name;

    @ApiModelProperty(value="简介")
    public String description;

    @ApiModelProperty(value="logo路径")
    public String logo;

    @ApiModelProperty(value="首屏播放的视频列表")
    public ArrayList<HomeUrlVo> videos;

    @ApiModelProperty(value="重点工作列表")
    public ArrayList<VrkeyworksDomain> keyWorks;

    @ApiModelProperty(value="中心获取的荣誉")
    public ArrayList<VrhonoursDomain> honours;

    @ApiModelProperty(value="地区")
    public Map<String, ArrayList<String>> areas;

    @ApiModelProperty(value="员工信息列表")
    public ArrayList<VrstaffExtaDomain> staff;

    @ApiModelProperty(value="设备信息列表")
    public HomeEquipmentsVo equipments;
}
