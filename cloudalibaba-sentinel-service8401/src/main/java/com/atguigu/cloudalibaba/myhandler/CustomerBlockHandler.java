package com.atguigu.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entyies.CommonRuslt;

/**
 * @create by  ytq
 * @Date 2022-7-18  21:11
 */
public class CustomerBlockHandler {

    public static CommonRuslt handlerException(BlockException exception)
    {
        return new CommonRuslt(4444,"按客戶自定义,global handlerException----1");
    }
    public static CommonRuslt handlerException2(BlockException exception)
    {
        return new CommonRuslt(4444,"按客戶自定义,global handlerException----2");
    }
}
