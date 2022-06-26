package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @create by  ytq
 * @Date 2022-6-4  21:27
 */
@Component
//实现服务类是为了做服务降级兜底的统一处理
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "这是服务兜底的方法 paymentInfo_OK 80端口";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "这是服务兜底的方法 paymentInfo_TimeOut 80端口";
    }
}
