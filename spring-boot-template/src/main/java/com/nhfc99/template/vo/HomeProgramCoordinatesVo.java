package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

@ApiModel(value = "项目地图坐标Model")
public class HomeProgramCoordinatesVo {
    @ApiModelProperty(value = "铁路")
    public Map<String, HomeProgramCoordinatesXYVo> railways;

    @ApiModelProperty(value = "市政")
    public Map<String, HomeProgramCoordinatesXYVo> highways;

    @ApiModelProperty(value = "公路")
    public Map<String, HomeProgramCoordinatesXYVo> subways;

    @ApiModelProperty(value = "水利")
    public Map<String, HomeProgramCoordinatesXYVo> waterways;
}
