package com.atguigu.alibabacloud.controller;

import com.atguigu.alibabacloud.domain.CommonResult;
import com.atguigu.alibabacloud.domain.Order;
import com.atguigu.alibabacloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 10:25
 *
 **/
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
