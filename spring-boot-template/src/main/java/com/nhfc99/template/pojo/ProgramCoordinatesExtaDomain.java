package com.nhfc99.template.pojo;

import lombok.Data;

@Data
public class ProgramCoordinatesExtaDomain {
    /**
     * 项目id
     */
    public String projectinfoid;

    /**
     * 项目名称
     */
    public String ProjectName;

    /**
     * 项目类型
     */
    public String BelongCategory;

    /**
     * x位置
     */
    public Integer x;

    /**
     * y位置
     */
    public Integer y;
}
