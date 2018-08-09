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
@ApiModel("产品版本信息")
@Data
@Table(name = "product_version")
public class Version implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
