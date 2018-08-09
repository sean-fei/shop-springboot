package com.sean.shop.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: sean
 * @CreateDate: 2018/8/9 10:43
 */
@ApiModel("产品基本信息")
@Data
public class ProductVO implements Serializable {

    @ApiModelProperty(value = "产品ID")
    private String productId;

    @ApiModelProperty(value = "产品code")
    private String productCode;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品描述")
    private String productDesc;

    @ApiModelProperty(value = "产品图片,存放图片URL")
    private String productImg;

}
