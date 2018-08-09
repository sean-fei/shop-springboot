package com.sean.shop.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *  @Author: sean
 *  @Date: 2018/8/9 10:46
 *
 */
@ApiModel("产品版本信息")
@Data
public class VersionVO implements Serializable {

    @ApiModelProperty(value = "版本ID")
    private String versionId;

    @ApiModelProperty(value = "版本code")
    private String versionCode;

    @ApiModelProperty(value = "版本name")
    private String versionName;

    @ApiModelProperty(value = "版本描述")
    private String versionDesc;

    @ApiModelProperty(value = "版本价格")
    private float price;

    @ApiModelProperty(value = "产品ID")
    private String productId;

}
