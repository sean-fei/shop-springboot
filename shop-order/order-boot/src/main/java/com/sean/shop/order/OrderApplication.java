package com.sean.shop.order;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: sean
 * @Date: 2018/8/17 10:06
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.sean.shop.order.mapper")
@EnableAutoConfiguration
public class OrderApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(OrderApplication.class).web(true).run(args);

    }

}
