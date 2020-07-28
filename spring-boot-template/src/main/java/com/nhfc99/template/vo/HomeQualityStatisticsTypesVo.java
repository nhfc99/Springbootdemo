package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "缺陷类型信息")
public class HomeQualityStatisticsTypesVo {
    @ApiModelProperty(value = "总数")
    public int count;

    @ApiModelProperty(value = "修改数量")
    public int repair;

    @ApiModelProperty(value = "总缺陷长度")
    public double length;//FaultLength

    @ApiModelProperty(value = "修复缺陷长度")
    public double repairlength;//FaultLength + IsFix
}
