package com.sean.shop.stock.service;

import com.github.pagehelper.PageInfo;
import com.sean.shop.stock.StockVO;

import java.util.List;

/**
 * @author sean
 */
public interface StockService {

    /**
     * 新增库存
     * @param stock
     * @return
     */
    StockVO saveStock(StockVO stock);

    /**
     * 修改库存
     * @param stockId
     * @param stock
     * @return
     */
    StockVO updateStock(String stockId, StockVO stock);

    /**
     * 根据ID删除库存
     * @param stockId
     * @return
     */
    StockVO deleteStockById(String stockId);

    /**
     * 根据ID获取库存信息
     * @param stockId
     * @return
     */
    StockVO getById(String stockId);

    /**
     * 根据商品，版本code进行过滤,带分页
     * @param productName
     * @param versionCode
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<StockVO> queryStockPage(String productName, String versionCode, int pageNum, int pageSize);

    /**
     * 根据商品，版本code进行过滤
     * @param productName
     * @param versionCode
     * @return
     */
    List<StockVO> queryStock(String productName, String versionCode);

}
