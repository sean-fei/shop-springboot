package com.sean.shop.stock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: sean
 * @CreateDate: 2018/8/8 14:03
 */
@ApiModel("库存")
@Data
public class StockVO implements Serializable {

    @ApiModelProperty(value = "库存ID")
    private String stockId;

    @ApiModelProperty(value = "库存数量")
    private String stockBalance;

    @ApiModelProperty(value = "商品ID")
    private String productId;

    @ApiModelProperty(value = "商品版本ID")
    private String versionId;

}
