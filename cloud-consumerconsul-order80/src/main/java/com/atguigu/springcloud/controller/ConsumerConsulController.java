package com.atguigu.springcloud.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @create by  ytq
 * @Date 2022-5-28  14:08
 */
@RestController
public class ConsumerConsulController {
    @Resource
    private RestTemplate restTemplate;

    private static final String URL="http://consul-provider-payment";

    @GetMapping("/getConsumerConsul")
    public String getConsumerConsul(){
        return restTemplate.getForObject(URL+"/getConsul",String.class);
    }

}
