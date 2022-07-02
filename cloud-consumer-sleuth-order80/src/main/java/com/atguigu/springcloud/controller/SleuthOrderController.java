package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @create by  ytq
 * @Date 2022-7-2  23:40
 */
@RestController
public class SleuthOrderController {
    @Resource
    private RestTemplate restTemplate;

    private  final static String URL="http://CLOUD-PROVIDER-SLEUTH-PAYMENT";

    @GetMapping("/consumer/getSleuth")
    public String getSleuthMassge(){
        String str = restTemplate.getForObject(URL+"/getSleuth", String.class);
        return str;
    }
}
