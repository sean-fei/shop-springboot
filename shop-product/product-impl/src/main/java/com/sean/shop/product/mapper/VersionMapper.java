package com.sean.shop.product.mapper;

import com.sean.shop.product.model.Version;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: sean
 * @Date: 2018/8/9 10:55
 */
@Repository
public interface VersionMapper extends Mapper<Version> {
}
