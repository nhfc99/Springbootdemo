package com.nhfc99.template.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProgramsAndTunnelsSqlResult implements Serializable {
    /**
     * 隧道id
     */
    public String tunnelinfoId;

    /**
     * 隧道名称
     */
    public String TunnelName;

    /**
     * 项目id
     */
    public String projectinfoId;

    /**
     * 区域名称
     */
    public String projectareaName;

    /**
     * 项目名称
     */
    public String ProjectName;

    /**
     * 项目类型
     */
    public String BelongCategory;
}
