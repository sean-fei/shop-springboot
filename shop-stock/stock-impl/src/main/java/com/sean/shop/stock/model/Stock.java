package com.sean.shop.stock.model;

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
 * @CreateDate: 2018/8/8 14:26
 */
@ApiModel("库存")
@Data
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "库存ID")
    private String stockId;

    @ApiModelProperty(value = "库存数量")
    private String stockBalance;

    @ApiModelProperty(value = "商品ID")
    private String productId;

    @ApiModelProperty(value = "商品版本ID")
    private String versionId;

}
