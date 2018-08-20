package com.sean.shop.order.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:16
 */

@Api(tags = { "订单管理接口" }, value = "订单管理接口")
@RestController
@RequestMapping("/orders")
public interface OrderController {
}
