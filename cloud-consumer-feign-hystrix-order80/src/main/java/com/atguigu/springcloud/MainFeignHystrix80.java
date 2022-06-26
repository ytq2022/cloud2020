package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @create by  ytq
 * @Date 2022-6-4  9:48
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class MainFeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeignHystrix80.class,args);
    }
}
