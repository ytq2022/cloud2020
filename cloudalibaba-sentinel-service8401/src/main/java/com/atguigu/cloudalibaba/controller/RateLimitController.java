package com.atguigu.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloudalibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entyies.CommonRuslt;
import com.atguigu.springcloud.entyies.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create by  ytq
 * @Date 2022-7-18  20:37
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonRuslt byResource(){
        return new CommonRuslt(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public CommonRuslt handleException(BlockException exception)
    {
        return new CommonRuslt(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")// 没有定义的blockHandler 使用系统自带的
    public CommonRuslt byUrl()
    {
        return new CommonRuslt(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }


   //使用自定义的类
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonRuslt customerBlockHandler()
    {
        return new CommonRuslt(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }
}
