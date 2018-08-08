package com.sean.shop.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @Author: sean
 * @CreateDate: 2018/8/8 14:24
 */
public class BeanUtils {

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    /**
     * 复制集合
     *
     * @param <E>
     * @param source
     * @param destinationClass
     * @return
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <E> List<E> copyToPropertiesIgnoreNull(List<?> source, Class<E> destinationClass)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (source.size() == 0) {
            return Collections.emptyList();
        }
        List<E> res = new ArrayList<E>(source.size());
        for (Object o : source) {
            E e = destinationClass.newInstance();
            copyPropertiesIgnoreNull(o, e);
            res.add(e);
        }
        return res;
    }

    public static <E> List<E> copyTo(List<?> source, Class<E> destinationClass)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (source.size() == 0) {
            return Collections.emptyList();
        }
        List<E> res = new ArrayList<E>(source.size());
        for (Object o : source) {
            E e = destinationClass.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(o, e);
            res.add(e);
        }
        return res;
    }

}
