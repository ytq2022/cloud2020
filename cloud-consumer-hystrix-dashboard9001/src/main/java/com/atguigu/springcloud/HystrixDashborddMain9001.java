package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @create by  ytq
 * @Date 2022-6-5  13:30
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashborddMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashborddMain9001.class,args);
    }
}
