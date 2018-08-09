package com.sean.shop.product.service;

import com.github.pagehelper.PageInfo;
import com.sean.shop.product.ProductVO;

import java.util.List;

/**
 * @Author: sean
 * @Date: 2018/8/9 10:48
 */
public interface ProductService {

    /**
     * 新增产品信息
     * @param product
     * @return
     */
    ProductVO save(ProductVO product);

    /**
     * 根据ID修改产品信息
     * @param productId
     * @param product
     * @return
     */
    ProductVO modify(String productId, ProductVO product);

    /**
     * 根据ID删除产品信息
     * @param productId
     * @return
     */
    ProductVO removeById(String productId);

    /**
     * 根据ID加载产品信息
     * @param productId
     * @return
     */
    ProductVO getById(String productId);

    /**
     * 根据产品，名称/code进行过滤,带分页
     * @param productCode
     * @param productName
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<ProductVO> queryPage(String productCode, String productName, int pageNum, int pageSize);

    /**
     * 根据产品，名称/code进行过滤,
     * @param productCode
     * @param productName
     * @return
     */
    List<ProductVO> query(String productCode, String productName);

}
