package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

@Data
@ApiModel("2屏幕--检测基地基础信息")
public class SecondTestingBaseVo {

    @ApiModelProperty(name = "名称")
    private String name;

    @ApiModelProperty(name = "描述")
    private String description;

    @ApiModelProperty(name = "视频")
    private ArrayList<Map<String, String>> videos;

    @ApiModelProperty(name = "重点工作列表")
    private ArrayList<TestingbaseDomainAllVo> presetparts;
}
