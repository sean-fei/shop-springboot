package com.sean.shop.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sean.shop.product.ProductVO;
import com.sean.shop.product.mapper.ProductMapper;
import com.sean.shop.product.model.Product;
import com.sean.shop.product.service.ProductService;
import com.sean.shop.utils.BeanUtils;
import com.sean.shop.utils.IDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sean
 * @Date: 2018/8/9 11:06
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public ProductVO save(ProductVO product) {
        Product entity = new Product();
        product.setProductId(IDGenerator.getUUID());
        BeanUtils.copyPropertiesIgnoreNull(product, entity);
        productMapper.insert(entity);
        return product;
    }

    @Override
    public ProductVO modify(String productId, ProductVO product) {
        if(null == product) {
            return null;
        }
        Product entity = this.getProductById(productId);
        if(null != entity) {
            BeanUtils.copyPropertiesIgnoreNull(product, entity);
            productMapper.updateByPrimaryKey(entity);
            return product;
        }
        return null;
    }

    @Override
    public ProductVO removeById(String productId) {
        ProductVO poduct = this.getById(productId);
        productMapper.deleteByPrimaryKey(productId);
        return poduct;
    }

    @Override
    public ProductVO getById(String productId) {
        Product entity = this.getProductById(productId);
        if(null == entity) {
            return null;
        }
        ProductVO instance = new ProductVO();
        BeanUtils.copyPropertiesIgnoreNull(entity, instance);
        return instance;
    }

    @Override
    public PageInfo<ProductVO> queryPage(String productCode, String productName, int pageNum, int pageSize) {
        List<ProductVO> voList = new ArrayList<ProductVO>();
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = this.findProduct(productCode, productName);
        try {
            voList = BeanUtils.copyToPropertiesIgnoreNull(products, ProductVO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new PageInfo<ProductVO>(voList);
    }

    @Override
    public List<ProductVO> query(String productCode, String productName) {
        List<ProductVO> voList = new ArrayList<ProductVO>();
        List<Product> products = this.findProduct(productCode, productName);
        try {
            voList = BeanUtils.copyToPropertiesIgnoreNull(products, ProductVO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return voList;
    }

    public Product getProductById(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    public List<Product> findProduct(String productCode, String productName) {
        Product product = new Product();
        product.setProductCode(productCode);
        product.setProductName(productName);
        return productMapper.select(product);
    }

}
