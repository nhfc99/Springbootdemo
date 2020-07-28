package com.nhfc99.template.pojo;

import com.nhfc99.template.domain.VrstaffDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("员工信息")
public class VrstaffExtaDomain extends VrstaffDomain {
    /**
     * 区域名称
     */
    public String area;

    @ApiModelProperty(value="用户详细信息")
    public String details;
}
