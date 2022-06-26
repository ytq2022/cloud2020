package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @create by  ytq
 * @Date 2022-5-30  21:07
 */
@SpringBootApplication
@EnableFeignClients //启动Openfeign功能
public class OrderFeignMaint80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMaint80.class,args);
    }
}
