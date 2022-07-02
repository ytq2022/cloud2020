package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @create by  ytq
 * @Date 2022-7-2  23:38
 */
@SpringBootApplication
@EnableEurekaClient
public class SleuthOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(SleuthOrder80.class,args);
    }
}
