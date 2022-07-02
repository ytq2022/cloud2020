package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @create by  ytq
 * @Date 2022-7-2  22:08
 */
@SpringBootApplication
@EnableEurekaClient
public class SleuthPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(SleuthPaymentMain8001.class,args);
    }
}
