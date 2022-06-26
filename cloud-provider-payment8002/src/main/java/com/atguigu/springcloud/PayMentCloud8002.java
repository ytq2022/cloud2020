package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @create by  ytq
 * @Date 2022/3/2  21:37
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.atguigu.springcloud.dao")  //在Dao中配合 @Repository 使用
@EnableDiscoveryClient
public class PayMentCloud8002 {

    public static void main(String[] args) {
        SpringApplication.run(PayMentCloud8002.class);
    }

}
