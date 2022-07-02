package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create by  ytq
 * @Date 2022-7-2  22:10
 */
@RestController
public class SleuthPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getSleuth")
    public String getSleuth(){
        return " sleuth port:"+serverPort;
    }

}
