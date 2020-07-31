package com.nhfc99.template.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 公司信息
 * </p>
 *
 * @author nhf
 * @since 2020-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_company")
@ApiModel(value="SysCompany", description="公司信息")
public class SysCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "公司名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "公司地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "联系电话")
    @TableField("telphone")
    private String telphone;

    @ApiModelProperty(value = "联系人")
    @TableField("contacts")
    private String contacts;

    @ApiModelProperty(value = "省")
    @TableField("province")
    private String province;

    @ApiModelProperty(value = "市")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "区")
    @TableField("zone")
    private String zone;

    @ApiModelProperty(value = "邮编")
    @TableField("postcode")
    private String postcode;

    @ApiModelProperty(value = "备注")
    @TableField("mem")
    private String mem;


}
