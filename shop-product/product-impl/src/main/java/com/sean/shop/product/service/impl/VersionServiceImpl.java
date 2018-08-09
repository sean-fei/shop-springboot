package com.sean.shop.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sean.shop.product.ProductVO;
import com.sean.shop.product.VersionVO;
import com.sean.shop.product.mapper.ProductMapper;
import com.sean.shop.product.mapper.VersionMapper;
import com.sean.shop.product.model.Product;
import com.sean.shop.product.model.Version;
import com.sean.shop.product.service.VersionService;
import com.sean.shop.utils.BeanUtils;
import com.sean.shop.utils.IDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sean
 * @Date: 2018/8/9 11:16
 */
@Service
public class VersionServiceImpl implements VersionService {

    @Resource
    private VersionMapper versionMapper;

    @Override
    public VersionVO save(VersionVO version) {
        Version entity = new Version();
        version.setVersionId(IDGenerator.getUUID());
        BeanUtils.copyPropertiesIgnoreNull(version, entity);
        versionMapper.insert(entity);
        return version;
    }

    @Override
    public VersionVO modify(String versionId, VersionVO version) {
        if (null == version) {
            return null;
        }
        Version entity = this.getVersionById(versionId);
        if (null != entity) {
            BeanUtils.copyPropertiesIgnoreNull(version, entity);
            versionMapper.updateByPrimaryKey(entity);
            return version;
        }
        return null;
    }

    @Override
    public VersionVO removeById(String versionId) {
        VersionVO version = this.getById(versionId);
        versionMapper.deleteByPrimaryKey(versionId);
        return version;
    }

    @Override
    public VersionVO getById(String versionId) {
        Version entity = this.getVersionById(versionId);
        if (null == entity) {
            return null;
        }
        VersionVO instance = new VersionVO();
        BeanUtils.copyPropertiesIgnoreNull(entity, instance);
        return instance;
    }

    @Override
    public PageInfo<VersionVO> queryPage(String versionCode, String versionName, String productId, int pageNum, int pageSize) {
        List<VersionVO> voList = new ArrayList<VersionVO>();
        PageHelper.startPage(pageNum, pageSize);
        List<Version> versions = this.findVersion(versionCode, versionName, productId);
        try {
            voList = BeanUtils.copyToPropertiesIgnoreNull(versions, VersionVO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new PageInfo<VersionVO>(voList);
    }

    @Override
    public List<VersionVO> query(String versionCode, String versionName, String productId) {
        List<VersionVO> voList = new ArrayList<VersionVO>();
        List<Version> versions = this.findVersion(versionCode, versionName, productId);
        try {
            voList = BeanUtils.copyToPropertiesIgnoreNull(versions, VersionVO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return voList;
    }

    public Version getVersionById(String versionId) {
        return versionMapper.selectOneByExample(versionId);
    }

    public List<Version> findVersion(String versionCode, String versionName, String productId) {
        Version version = new Version();
        version.setProductId(productId);
        version.setVersionCode(versionCode);
        version.setVersionName(versionName);
        return versionMapper.select(version);
    }

}
