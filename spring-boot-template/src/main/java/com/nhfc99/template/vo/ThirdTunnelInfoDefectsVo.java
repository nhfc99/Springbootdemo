package com.nhfc99.template.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;

@Data
@ApiModel(value = "隧道报告")
public class ThirdTunnelInfoDefectsVo {
    private String id;
    private String report;
    private String type;
    private String position;
    private Integer startKiloMetre;
    private Double startMetre;
    private Double length;
    private String check;
    private String info_01;
    private String info_02;
    private String info_03;
    private ArrayList<String> img;
    private Boolean isbug;
    private Boolean repaired;
    private String repaired_Report;
    private String repaired_info_01;
    private ArrayList<String> repaired_img;
    private String report_url;
    private String repaired_report_url;

    /**
     * 修复报告编号
     */
    @JsonIgnore
    private String tunnelFixReportId;
}
