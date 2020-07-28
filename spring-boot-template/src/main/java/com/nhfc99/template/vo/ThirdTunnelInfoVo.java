package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@ApiModel(value = "隧道信息")
public class ThirdTunnelInfoVo {
    private String id;
    private String name;// 名称
    private String address;// 地点
    private String code;
    private Integer startKM;
    private BigDecimal startM;
    private Integer endKM;
    private BigDecimal endM;
    private BigDecimal planLength;
    private BigDecimal buildLength;
    private BigDecimal checkLength;
    private BigDecimal betonLength;
    private String explains;
    private ArrayList<ThirdTunnelInfoDefectsVo> defects;
}
