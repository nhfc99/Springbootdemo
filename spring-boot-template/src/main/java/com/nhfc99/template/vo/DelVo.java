package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("删除模型")
public class DelVo {
    @ApiModelProperty("id")
    @Valid
    @NotNull(message = "不可以为空对象")
    private Long id;
}
