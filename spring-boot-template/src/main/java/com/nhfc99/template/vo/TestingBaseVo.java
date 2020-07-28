package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "检测基地TestingBaseVo")
@Data
public class TestingBaseVo {
    @ApiModelProperty(value = "标题", required = true)
    @NotNull(message = "文本消息不可以为空")
    @Valid
    private String title;

    @ApiModelProperty(value = "名称", required = true)
    @NotNull(message = "文本消息不可以为空")
    @Valid
    private String name;

    @ApiModelProperty(value = "描述", required = true)
    @NotNull(message = "文本消息不可以为空")
    @Valid
    private String explains;
}
