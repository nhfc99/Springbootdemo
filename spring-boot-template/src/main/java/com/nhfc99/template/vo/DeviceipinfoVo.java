package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "设备信息ip")
public class DeviceipinfoVo {
    @ApiModelProperty(name = "设备名称:只能传递voice、play")
    @NotNull(message = "设备名称不可以为空")
    @Valid
    private String name;

    @ApiModelProperty(name = "ip地址")
    @NotNull(message = "ip地址不可以为空")
    @Valid
    private String ip;

    @ApiModelProperty(name = "端口号")
    private String port;
}
