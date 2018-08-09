package com.sean.shop.stock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sean.shop.stock.StockVO;
import com.sean.shop.stock.mapper.StockMapper;
import com.sean.shop.stock.model.Stock;
import com.sean.shop.stock.service.StockService;
import com.sean.shop.utils.BeanUtils;
import com.sean.shop.utils.IDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sean
 * @CreateDate: 2018/8/8 14:18
 */
@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public StockVO saveStock(StockVO stock) {
        Stock entity = new Stock();
        stock.setProductId(IDGenerator.getUUID());
        BeanUtils.copyPropertiesIgnoreNull(stock, entity);
        stockMapper.insert(entity);
        return stock;
    }

    @Override
    public StockVO updateStock(String stockId, StockVO stock) {
        if(null == stock) {
            return null;
        }
        Stock entity = this.getStockById(stockId);
        if(null != entity) {
            BeanUtils.copyPropertiesIgnoreNull(stock, entity);
            stockMapper.updateByPrimaryKey(entity);
            return stock;
        }
        return null;
    }

    @Override
    public StockVO deleteStockById(String stockId) {
        StockVO stockVO = this.getById(stockId);
        stockMapper.deleteByPrimaryKey(stockId);
        return stockVO;
    }

    @Override
    public StockVO getById(String stockId) {
        Stock entity = this.getStockById(stockId);
        if(null == entity) {
            return null;
        }
        StockVO instance = new StockVO();
        BeanUtils.copyPropertiesIgnoreNull(entity, instance);
        return instance;
    }

    @Override
    public PageInfo<StockVO> queryStockPage(String productName, String versionCode, int pageNum, int pageSize) {
        List<StockVO> voList = new ArrayList<StockVO>();
        PageHelper.startPage(pageNum, pageSize);
        List<Stock> stocks = this.findStocks(productName, versionCode);
        try {
            voList = BeanUtils.copyToPropertiesIgnoreNull(stocks, StockVO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new PageInfo<StockVO>(voList);
    }

    @Override
    public List<StockVO> queryStock(String productName, String versionCode) {
        List<StockVO> voList = new ArrayList<StockVO>();
        List<Stock> stocks = this.findStocks(productName, versionCode);
        try {
            voList = BeanUtils.copyToPropertiesIgnoreNull(stocks, StockVO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return voList;
    }

    public Stock getStockById(String stockId) {
        return stockMapper.selectByPrimaryKey(stockId);
    }

    public List<Stock> findStocks(String productName, String versionCode) {
        Stock stock = new Stock();
//        stock.setVersionCode(productCode);
//        stock.s.setProductName(productName);
        return stockMapper.select(stock);
    }

}
