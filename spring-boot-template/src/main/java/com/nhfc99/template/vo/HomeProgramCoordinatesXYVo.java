package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "x和y值")
public class HomeProgramCoordinatesXYVo {
    @ApiModelProperty(value = "x像素坐标")
    public int x;
    
    @ApiModelProperty(value = "y像素坐标")
    public int y;
}
