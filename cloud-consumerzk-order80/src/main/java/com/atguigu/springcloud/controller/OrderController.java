package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @create by  ytq
 * @Date 2022-5-27  11:33
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //直接写的是服务发布名称 调用的cloud-provider-payment8004
    private static final String URL="http://cloud-payment-service";

    @GetMapping("/getZkPayment")
    public String getPayment(){
        String object = restTemplate.getForObject(URL+"/paymentzk", String.class);
        return object;
    }

}
