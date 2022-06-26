package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentCirutServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create by  ytq
 * @Date 2022-6-4  23:01
 */
@RestController
public class PaymentCirutController {
    @Autowired
    private PaymentCirutServcie paymentCirutServcie;

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentCirutServcie.paymentCircuitBreaker(id);
    }
}
