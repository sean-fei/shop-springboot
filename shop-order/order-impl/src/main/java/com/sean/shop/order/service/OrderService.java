package com.sean.shop.order.service;

import com.sean.shop.order.OrderVO;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:38
 */
public interface OrderService {

    /**
     * 新增订单
     * @param order
     * @return
     */
    OrderVO save(OrderVO order);

    /**
     * 根据ID修改订单信息
     * @param orderId
     * @param order
     * @return
     */
    OrderVO modify(String orderId, OrderVO order);

    /**
     * 根据ID加载订单信息
     * @param orderId
     * @return
     */
    OrderVO getById(String orderId);

    /**
     * 根据ID删除订单信息
     * @param orderId
     * @return
     */
    OrderVO removeById(String orderId);

}
