package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @create by  ytq
 * @Date 2022/3/7  22:17
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class,args);
    }
}
