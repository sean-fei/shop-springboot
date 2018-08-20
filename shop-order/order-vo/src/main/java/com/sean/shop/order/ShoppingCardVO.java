package com.sean.shop.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:24
 */
@ApiModel("购物车信息")
@Data
public class ShoppingCardVO implements Serializable {

    @ApiModelProperty(value = "购物车ID")
    private String cardId;

    @ApiModelProperty(value = "购物车code")
    private String cardCode;

    @ApiModelProperty(value = "用户ID")
    private String userId;

}
