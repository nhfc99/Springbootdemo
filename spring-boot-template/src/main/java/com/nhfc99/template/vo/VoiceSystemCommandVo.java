package com.nhfc99.template.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("语音和系统对应指令")
@Data
public class VoiceSystemCommandVo {
    /**
     *
     */
    @ApiModelProperty("语音指令Id")
    private Long id;

    /**
     * 语音指令
     */
    @ApiModelProperty("语音指令")
    private String vcommand;

    /**
     * 系统内部指令
     */
    @ApiModelProperty("系统内部指令")
    private String scommand;

    /**
     * 语音备注
     */
    @ApiModelProperty("备注")
    private String voicemem;

    /**
     * 系统备注
     */
    @ApiModelProperty("系统备注")
    private String sysmem;

    /**
     * 内容数据
     */
    @ApiModelProperty("内容")
    private String data;
}
