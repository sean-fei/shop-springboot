package com.sean.shop.order.mapper;

import com.sean.shop.order.model.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:33
 */
@Repository
public interface OrderMapper extends Mapper<Order> {
}
