package com.sean.shop.product.mapper;

import com.sean.shop.product.model.Product;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: sean
 * @Date: 2018/8/9 10:49
 */
@Repository
public interface ProductMapper extends Mapper<Product> {
}
