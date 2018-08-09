package com.sean.shop.commons.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: sean
 * @CreateDate: 2018/8/9 9:31
 */
public class SpringApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext appCtx = null;

    public SpringApplicationContextHolder() {
    }

    public static ApplicationContext getApplicationContext() {
        return appCtx;
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        appCtx = ctx;
        String applicationName = ctx.getApplicationName();
        if (applicationName.contains("_")) {
            throw new IllegalStateException("spring.application.name is not allowed to include underlines :" + applicationName);
        }
    }

    public ApplicationContext getAppContext() {
        return appCtx;
    }

}
