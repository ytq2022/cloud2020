package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @create by  ytq
 * @Date 2022/3/7  20:27
 */
@Configuration
public class ApplicationConfig {

    @Bean
   // @LoadBalanced //启动负载均衡
    public RestTemplate getRestTemplate23(){
        return new RestTemplate();
    }
}
