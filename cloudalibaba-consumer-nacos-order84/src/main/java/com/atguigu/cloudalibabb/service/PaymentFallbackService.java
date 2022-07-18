package com.atguigu.cloudalibabb.service;

import com.atguigu.springcloud.entyies.CommonRuslt;
import com.atguigu.springcloud.entyies.Payment;
import org.springframework.stereotype.Component;

/**
 * @create by  ytq
 * @Date 2022-7-19  6:00
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonRuslt<Payment> paymentSQL(Long id) {
        return new CommonRuslt<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
