package com.atguigu.alibabbcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @create by  ytq
 * @Date 2022-7-3  16:00
 */
@RestController
public class NacosOrderController {
    @Resource
    private RestTemplate restTemplate;
    //从application.yml文件中取到
    @Value("${server-url.my_nacos_url}")
    private String service_url;
    @GetMapping("/consumer/payment/nacos/{id}")
    public String getServer(@PathVariable("id") Integer id){
       return   restTemplate.getForObject(service_url + "/payment/nacos/" + id, String.class);
    }

}
