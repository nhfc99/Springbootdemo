package com.nhfc99.template.pojo;

import lombok.Data;

@Data
public class TunneltestfaultCalculatModel {
    // 规划隧道总长（KM），计算方法：相应隧道的规划长度合计
    private double planLength = 0;
    // 衬砌总长（KM） ，计算方法：相应隧道的已衬砌长度合计
    private double betonLength = 0;
}
