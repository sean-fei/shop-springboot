package com.sean.shop.order.model;

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
 * @Date: 2018/8/17 10:31
 */

@Data
@ApiModel("购物车Item信息")
@Table(name = "shopping_card_item")
public class ShoppingCardItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "购物车ItemID")
    private String itemId;

    @ApiModelProperty(value = "商品数量")
    private int num;

    @ApiModelProperty(value = "产品版本ID")
    private String versionId;

    @ApiModelProperty(value = "购物车ID")
    private String cardId;

    @ApiModelProperty(value = "商品ID")
    private String productId;

}
