package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @create by  ytq
 * @Date 2022-6-4  9:07
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //启用备用方法或者兜底方法
public class MainHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainHystrix8001.class,args);
    }



}
