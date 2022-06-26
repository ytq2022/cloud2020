package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @create by  ytq
 * @Date 2022-5-30  23:19
 */
@Configuration
public class FeignConfig {
    @Bean
    //feign.Logger 是feign包下的logger
    public Logger.Level getLevel(){
        return Logger.Level.FULL;
    }
}
