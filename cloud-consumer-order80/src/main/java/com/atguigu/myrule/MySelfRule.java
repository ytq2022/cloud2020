package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @create by  ytq
 * @Date 2022-5-29  11:28
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule randomRule(){
        return new RandomRule();//定义随机类
    }
}
