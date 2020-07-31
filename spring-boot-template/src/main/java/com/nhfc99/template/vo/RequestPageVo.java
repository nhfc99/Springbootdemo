package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="RequestPageVo", description = "分页接收模型")
public class RequestPageVo {
    @ApiModelProperty("页数")
    private int page;

    @ApiModelProperty("数量")
    private int pageSize;
}
