package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "检测基地更新标题")
@Data
public class TestingBaseUpdateTitleVo {
    @ApiModelProperty(value = "父id，每条记录的parentId", required = true)
    @NotNull(message = "父id不可以为空")
    @Valid
    private Long parentId;

    @ApiModelProperty(value = "标题", required = true)
    @NotNull(message = "标题不可以为空")
    @Valid
    private String title;
}
