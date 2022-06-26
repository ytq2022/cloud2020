package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @create by  ytq
 * @Date 2022/3/7  20:25
 */

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class ConsumerOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80.class,args);
    }
}
