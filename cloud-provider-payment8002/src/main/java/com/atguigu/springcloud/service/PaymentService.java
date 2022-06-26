package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entyies.Payment;

/**
 * @create by  ytq
 * @Date 2022/3/3  22:00
 */
public interface PaymentService {

    public int create(Payment payment);


    public Payment queryPaymentById(Long id);
}
