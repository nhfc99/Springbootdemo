package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

@ApiModel(value = "项目部及所辖隧道名称区域列表")
public class HomeProgramsAndTunnelsItemVo {
    @ApiModelProperty(value = "项目数量")
    public int programCount;

    @ApiModelProperty(value = "隧道数量")
    public int tunnelCount;

    @ApiModelProperty(value = "区域列表")
    public Map<String, HomeProgramsAndTunnelsItemAreaVo> areas;
}
