package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "接收消息数据")
public class StringVo {
    @ApiModelProperty(value = "接收文本消息", required = true)
    @NotNull(message = "文本消息不可以为空")
    @Valid
    private String message;
}
