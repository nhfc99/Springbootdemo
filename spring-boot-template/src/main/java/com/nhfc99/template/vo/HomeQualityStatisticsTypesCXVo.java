package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "缺陷类型信息加入了测线长度")
public class HomeQualityStatisticsTypesCXVo extends HomeQualityStatisticsTypesVo {
    @ApiModelProperty(value = "测线长度")
    public Long TestLineLength;
}
