package com.sean.shop.stock.mapper;

import com.sean.shop.stock.model.Stock;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author sean
 */
@Repository
public interface StockMapper extends Mapper<Stock> {
}
