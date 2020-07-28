package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Map;

//项目类型 -> 地区 -> 项目 -> 隧道

@ApiModel(value = "项目部及所辖隧道名称列表")
public class HomeProgramsAndTunnelsVo {
    @ApiModelProperty(value = "项目数量")
    public int programCount;

    @ApiModelProperty(value = "隧道数量")
    public int tunnelCount;

    @ApiModelProperty(value = "铁路项目")
    public HomeProgramsAndTunnelsItemVo railways;

    @ApiModelProperty(value = "公路项目")
    public HomeProgramsAndTunnelsItemVo highways;

    @ApiModelProperty(value = "地铁项目")
    public HomeProgramsAndTunnelsItemVo subways;

    @ApiModelProperty(value = "水利项目")
    public HomeProgramsAndTunnelsItemVo waterways;
}
