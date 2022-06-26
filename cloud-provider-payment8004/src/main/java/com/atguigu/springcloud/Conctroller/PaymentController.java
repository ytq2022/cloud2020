package com.atguigu.springcloud.Conctroller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @create by  ytq
 * @Date 2022/3/3  22:02
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    //增加服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/paymentzk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }








}
