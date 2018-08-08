package com.sean.shop.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: sean
 * @CreateDate: 2018/8/8 12:54
 */
//@EnableDiscoveryClient
//@EnableTarestClients
//@EnableCircuitBreaker
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.sean.shop.stock.mapper")
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

}
