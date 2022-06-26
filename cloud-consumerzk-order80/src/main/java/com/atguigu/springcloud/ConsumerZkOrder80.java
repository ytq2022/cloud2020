package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @create by  ytq
 * @Date 2022-5-27  11:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrder80.class,args);
    }

}
