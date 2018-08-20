package com.sean.shop.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:20
 */
@ApiModel("订单基本信息")
@Data
public class OrderVO implements Serializable {

    @ApiModelProperty(value = "订单ID")
    private String orderId;

    @ApiModelProperty(value = "订单code")
    private String orderCode;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "订单状态")
    private String orderState;

    /**
     * orderDetail: [
     * 	{
     * 		"versionId" : 商品版本ID
     * 		"num": 商品数量,
     * 		"cardId": 购物车ID,
     * 		"itemId": 购物车itemId
     * 	},
     * {
     * 		"versionId" : 商品版本ID
     * 		"num": 商品数量,
     * 		"cardId": 购物车ID,
     * 		"itemId": 购物车itemId
     * }
     * ]
     */
    @ApiModelProperty(value = "订单明细,以数组形式存放购物车item")
    private String orderDetail;

    /**
     * 前台发送数据格式：
     * [{
     * 	"itemId": 购物车itemId
     * },{
     * 	"itemId": 购物车itemId
     * }
     * ]
     */
    @ApiModelProperty(value = "产品ID")
    private ShoppingCardItemVO[] cardItems;

    @ApiModelProperty(value = "订单价格")
    private float totalPrice;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
