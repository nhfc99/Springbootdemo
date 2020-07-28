package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel("用户信息")
@Data
public class MessageUserVo {
    @ApiModelProperty(value = "用户名",required = true)
    @NotNull(message = "用户名不可以为空")
    @Valid
    private String name;

    @ApiModelProperty(value = "手机号", required = true)
    @NotNull(message = "手机号不可以为空")
    @Valid
    private String phone;
}
