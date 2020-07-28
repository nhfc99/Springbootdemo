package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("2屏幕--隧道信息")
public class SecondProgramInfoTunnelsClass {
    String id;
    String name;
    SecondProgramInfoTunnelsStatisticsClass qualityStatistics;
}
