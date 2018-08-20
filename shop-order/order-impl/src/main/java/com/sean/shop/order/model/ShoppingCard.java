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
 * @Date: 2018/8/17 10:30
 */

@Data
@ApiModel("购物车信息")
@Table(name = "shopping_card")
public class ShoppingCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "购物车ID")
    private String cardId;

    @ApiModelProperty(value = "购物车CODE")
    private String cardCode;

    @ApiModelProperty(value = "用户ID")
    private String userId;

}
