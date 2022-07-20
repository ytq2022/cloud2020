package com.atguigu.alibabacloud;
/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 8:37
 *
 **/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderServerMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServerMain2001.class,args);
    }
}
