package com.nhfc99.template.vo;

import com.nhfc99.template.domain.TestingbaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;

@ApiModel(value = "重点工作列表")
@Data
public class TestingbaseDomainAllVo {

    @ApiModelProperty(name = "重点工作标题id")
    private Long id;

    @ApiModelProperty(name = "标题")
    private String title;

    @ApiModelProperty(name = "重点工作列表")
    private ArrayList<TestingbaseDomain> defects;
}
