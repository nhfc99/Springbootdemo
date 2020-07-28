package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "标杆项目部TOP3")
@Data
public class HomeBenchmarkProjectVo {
    @ApiModelProperty(value="名称")
    public String name;

    @ApiModelProperty(value="图片")
    public String img;

    @ApiModelProperty(value="总缺陷率")
    public int totalDefectRate;

    @ApiModelProperty(value="整改合格率")
    public int repairQualifiedRate;
}
