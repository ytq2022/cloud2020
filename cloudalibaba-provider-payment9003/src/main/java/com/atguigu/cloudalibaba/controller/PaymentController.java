package com.atguigu.cloudalibaba.controller;

import com.atguigu.springcloud.entyies.CommonRuslt;
import com.atguigu.springcloud.entyies.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @create by  ytq
 * @Date 2022-7-19  5:43
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    //模拟数据库里的记录
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static
    {
        hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonRuslt<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        Payment payment = hashMap.get(id);
        CommonRuslt<Payment> result = new CommonRuslt(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }
}
