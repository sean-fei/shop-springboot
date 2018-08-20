package com.sean.shop.order.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:29
 */
@Data
@ApiModel("订单信息")
@Table(name = "order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "订单ID")
    private String orderId;

    @ApiModelProperty(value = "订单code")
    private String orderCode;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "订单状态")
    private String orderState;

    @ApiModelProperty(value = "订单明细,存放商品版本信息")
    private String orderDetail;

    @ApiModelProperty(value = "订单价格")
    private float totalPrice;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
