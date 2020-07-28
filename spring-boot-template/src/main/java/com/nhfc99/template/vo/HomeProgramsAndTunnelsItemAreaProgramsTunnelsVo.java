package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "隧道信息")
public class HomeProgramsAndTunnelsItemAreaProgramsTunnelsVo {
    @ApiModelProperty(value = "id")
    public String id;

    @ApiModelProperty(value = "隧道名称")
    public String name;
}