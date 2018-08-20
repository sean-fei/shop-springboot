package com.sean.shop.order.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:17
 */

@Api(tags = { "商品管理接口" }, value = "商品管理接口")
@RestController
@RequestMapping("/products")
public interface ProductController {
}
