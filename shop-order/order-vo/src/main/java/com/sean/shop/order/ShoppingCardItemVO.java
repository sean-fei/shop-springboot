package com.sean.shop.order;

import com.sean.shop.product.ProductVO;
import com.sean.shop.product.VersionVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:25
 */
@ApiModel("购物车商品信息")
@Data
public class ShoppingCardItemVO implements Serializable {

    @ApiModelProperty(value = "购物车ItemID")
    private String itemId;

    @ApiModelProperty(value = "商品数量")
    private int num;

    @ApiModelProperty(value = "商品")
    private ProductVO product;

    @ApiModelProperty(value = "商品版本")
    private VersionVO version;

    @ApiModelProperty(value = "购物车")
    private ShoppingCardVO card;

}
