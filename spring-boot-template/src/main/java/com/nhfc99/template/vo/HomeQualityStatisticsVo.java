package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

@ApiModel(value = "当前range范围内的隧道质量数据统计Model")
public class HomeQualityStatisticsVo {
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

    @ApiModelProperty(value = "规划隧道总长（KM），计算方法：相应隧道的规划长度合计")
    public double planLength;

    @ApiModelProperty(value = "衬砌总长（KM） ，计算方法：相应隧道的已衬砌长度合计")
    public double betonLength;

    @ApiModelProperty(value = "测线总长（M），计算方法：相应隧道的测线长度合计")
    public double checkLength;

    @ApiModelProperty(value = "检测比率（%），计算方法：测线总长度 / 相应的衬砌总长度")
    public double checkRate;
    
    @ApiModelProperty(value = "当前range范围内，缺陷记录数的分类统计")
    public Map<String, HomeQualityStatisticsTypesVo> types;

    @ApiModelProperty(value = "当前range范围内，时间统计数据")
    public Map<String, Map<String, Map<String, HomeQualityStatisticsTypesVo>>> times;
}
