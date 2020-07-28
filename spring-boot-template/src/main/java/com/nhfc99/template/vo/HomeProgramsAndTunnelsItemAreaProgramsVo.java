package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

@ApiModel(value = "项目信息")
public class HomeProgramsAndTunnelsItemAreaProgramsVo {
    @ApiModelProperty(value = "id")
    public String id;

    @ApiModelProperty(value = "隧道列表")
    public ArrayList<HomeProgramsAndTunnelsItemAreaProgramsTunnelsVo> tunnels;
}