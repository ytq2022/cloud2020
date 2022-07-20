package com.atguigu.alibabacloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 9:48
 *
 **/
@Configuration
@MapperScan({"com.atguigu.alibabacloud.dao"})
public class MyBatisConfig {
}
