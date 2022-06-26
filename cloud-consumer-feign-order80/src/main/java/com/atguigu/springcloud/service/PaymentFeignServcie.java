package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entyies.CommonRuslt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @create by  ytq
 * @Date 2022-5-30  21:21
 */
@Component
@FeignClient(name="CLOUD-PAYMENT-SERVICE") //从eureka中发布的列表中取到
public interface PaymentFeignServcie {

    @GetMapping("/payment/get/{id}")//8001或者8001服务着的请求路径
    public CommonRuslt queryPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/getTimeoutPort")
    public String getTimeoutPort();
}
