package com.sean.shop.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: sean
 * @Date: 2018/8/9 10:53
 */
@ApiModel("产品基本信息")
@Data
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
