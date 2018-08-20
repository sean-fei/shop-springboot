package com.sean.shop.order.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:18
 */
@Api(tags = { "购物车管理接口" }, value = "购物车管理接口")
@RestController
@RequestMapping("/shop/cards")
public interface ShoppingCardController {
}
