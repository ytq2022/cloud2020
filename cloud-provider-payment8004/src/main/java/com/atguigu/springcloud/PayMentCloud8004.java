package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @create by  ytq
 * @Date 2022/3/2  21:37
 */
@SpringBootApplication
//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class PayMentCloud8004 {

    public static void main(String[] args) {
        SpringApplication.run(PayMentCloud8004.class);
    }

}
