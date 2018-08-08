package com.sean.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: sean
 * @CreateDate: 2018/8/8 14:29
 */
public class IDGenerator {

    /**
     * 生产UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生产业务CODE
     * @return
     */
    public static String getBusinessCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date()).toString();
    }

}
