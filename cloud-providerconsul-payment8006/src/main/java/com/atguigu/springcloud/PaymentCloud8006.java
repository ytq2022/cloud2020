package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @create by  ytq
 * @Date 2022-5-27  22:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentCloud8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentCloud8006.class,args);
    }
}
