package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @create by  ytq
 * @Date 2022-5-28  14:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrder80.class,args);
    }
}
