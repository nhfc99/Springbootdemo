package com.nhfc99.template.pojo;

import lombok.Data;

@Data
public class DataCalculatDomain {
    private double defectLength; // 缺陷总长度（M）   ，计算方法：缺陷记录中每个缺陷都有一个长度，累加即可			tunneltestfault -> FaultLength
    private long defectCount;  // 缺陷总数         ，计算方法：缺陷记录每个记录都有一个“是否为缺陷”的标识，将值为true的记录数量统计即可.    	tunneltestfault统计数量
    private double defectRate;   // 总缺陷率（%）,计算方法：缺陷总长度 / 测线总长度 defectLength/checkLength
    private long defectrepairCount; //缺陷修复总数       ，计算方法：缺陷记录中标识为“已修复”的记录总数量			tunneltestfault -> IsFix
    private long keyDefectCount;    // 重大缺陷总数      ，计算方法：标识为“重大缺陷”的记录的数量					tunneltestfault -> FaultLevel
    private long keyDefectRepairCount; // 重大缺陷修复总数  ，计算方法：标识为“已修复”“重大缺陷”的记录数量		tunneltestfault -> IsFix,FaultLevel
    private double planLength;      // 规划隧道总长（KM），计算方法：相应隧道的规划长度合计      tunnelinfo -> TunnelLength
    private double betonLength;     // 衬砌总长（KM） ，计算方法：相应隧道的已衬砌长度合计						tunnelinfo -> FixCrackLength
    private double checkLength;     // 测线总长（M）      ，计算方法：相应隧道的测线长度合计						tunneltestlinedetail -> TestLineLength
    private double checkRate;       // 检测比率（%）     ，计算方法：测线总长度 / 相应的衬砌总长度   checkLength/betonLength
    private double defectrepairLength;  //已修复缺陷长度
}
