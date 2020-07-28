package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Map;

@Data
@ApiModel("2屏幕--隧道详细信息")
public class SecondProgramInfoTunnelsStatisticsClass {
    double checkRate;
    double defectRate;
    Long defectCount;
    Map<String, Double> defectRageTypes;
    double defectRepairRate;
    Long defectRepairCount;
    Map<String, Double> defectRepairRateTypes;
}
