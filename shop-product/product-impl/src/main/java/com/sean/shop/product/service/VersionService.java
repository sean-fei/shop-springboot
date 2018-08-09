package com.sean.shop.product.service;

import com.github.pagehelper.PageInfo;
import com.sean.shop.product.ProductVO;
import com.sean.shop.product.VersionVO;

import java.util.List;

/**
 * @Author: sean
 * @Date: 2018/8/9 10:58
 */
public interface VersionService {

    /**
     * 新增产品版本信息
     * @param version
     * @return
     */
    VersionVO save(VersionVO version);

    /**
     * 根据ID修改产品版本信息
     * @param versionId
     * @param version
     * @return
     */
    VersionVO modify(String versionId, VersionVO version);

    /**
     * 根据ID删除产品版本信息
     * @param versionId
     * @return
     */
    VersionVO removeById(String versionId);

    /**
     * 根据ID加载产品版本信息
     * @param versionId
     * @return
     */
    VersionVO getById(String versionId);

    /**
     * 根据 code，name, productId 过滤产品版本,带分页
     * @param versionCode
     * @param versionName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<VersionVO> queryPage(String versionCode, String versionName, String productId, int pageNum, int pageSize);

    /**
     * 根据 code，name, productId 过滤产品版本,
     * @param versionCode
     * @param versionName
     * @param productId
     * @return
     */
    List<VersionVO> query(String versionCode, String versionName, String productId);

}
