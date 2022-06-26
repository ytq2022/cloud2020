package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @create by  ytq
 * @Date 2022-5-27  22:55
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getConsul")
    public String getConsul(){
        return "springcloud consul port: \t"+serverPort+"\t"+ UUID.randomUUID().toString();

    }
}
