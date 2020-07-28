package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;

@ApiModel("2屏幕--当前data指定项目部的数据信息")
@Data
public class SecondProgramInfoVo {
    String id;

    @ApiModelProperty(value = "项目名称")
    String name;

    @ApiModelProperty(value = "项目地点")
    String address;

    @ApiModelProperty(value = "项目部名称")
    String department;

    @ApiModelProperty(value = "项目类型")
    String type;

    @ApiModelProperty(value = "描述信息")
    String explains;

    @ApiModelProperty(value = "视频列表")
    String[] videos;

    @ApiModelProperty(value = "隧道列表")
    ArrayList<SecondProgramInfoTunnelsClass> tunnels;
}
