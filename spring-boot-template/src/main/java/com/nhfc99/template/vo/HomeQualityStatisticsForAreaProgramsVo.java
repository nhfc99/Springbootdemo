package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class HomeQualityStatisticsForAreaProgramsVo {
    @ApiModelProperty(value = "缺陷总长度（M，计算方法：缺陷记录中每个缺陷都有一个长度，累加即可")
    public double defectLength;

    @ApiModelProperty(value = "缺陷总数，计算方法：缺陷记录每个记录都有一个“是否为缺陷”的标识，将值为true的记录数量统计即可")
    public long defectCount;

    @ApiModelProperty(value = "总缺陷率（%）,计算方法：缺陷总长度 / 测线总长度")
    public double defectRate;

    @ApiModelProperty(value = "缺陷修复总数，计算方法：缺陷记录中标识为“已修复”的记录总数量")
    public long defectrepairCount;

    @ApiModelProperty(value = "重大缺陷总数，计算方法：标识为“重大缺陷”的记录的数量")
    public long keyDefectCount;

    @ApiModelProperty(value = "重大缺陷修复总数，计算方法：标识为“已修复”“重大缺陷”的记录数量")
    public long keyDefectRepairCount;

    @ApiModelProperty(value = "缺陷修复总长，计算方法：缺陷记录中标识为“已修复”的记录总长度")
    public double defectrepairLength;

    @ApiModelProperty(value = "衬砌总长（KM） ，计算方法：相应隧道的已衬砌长度合计")
    public double betonLength;

    @ApiModelProperty(value = "规划隧道总长（KM），计算方法：相应隧道的规划长度合计")
    public double planLength;

    @ApiModelProperty(value = "测线总长（M），计算方法：相应隧道的测线长度合计")
    public double checkLength;

    @ApiModelProperty(value = "当前range范围内，缺陷记录数的分类统计")
    public Map<String, HomeQualityStatisticsTypesVo> types;
}
