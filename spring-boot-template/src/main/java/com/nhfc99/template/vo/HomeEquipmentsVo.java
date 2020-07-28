package com.nhfc99.template.vo;

import com.nhfc99.template.domain.VrequipmentsDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

@ApiModel(value = "设备信息")
public class HomeEquipmentsVo {
    public int count;

    @ApiModelProperty(value="设备信息列表")
    public ArrayList<VrequipmentsDomain> equipments;
}
