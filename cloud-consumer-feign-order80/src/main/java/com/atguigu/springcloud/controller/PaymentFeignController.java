package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entyies.CommonRuslt;
import com.atguigu.springcloud.service.PaymentFeignServcie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @create by  ytq
 * @Date 2022-5-30  21:30
 */
@RestController
public class PaymentFeignController {
    @Resource
    private PaymentFeignServcie paymentFeignServcie;

    @GetMapping("/consumer/feign/payment/get/{id}")
    public CommonRuslt queryPayment(@PathVariable("id") Long id){
        return paymentFeignServcie.queryPayment(id);
    }


    @GetMapping("/consumer/feign/payment/getTimeoutPort")
    public String getTimeoutPort(){
        return paymentFeignServcie.getTimeoutPort();
    }
}
