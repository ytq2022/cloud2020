package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @create by  ytq
 * @Date 2022-6-4  9:12
 */
@Service
public class PaymentService {

    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id)
    {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }

    /**
     * 超时访问，演示降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    //fallbackMethod表示服务超时或异常使用备用方法paymentInfo_TimeOutHandler
    //@HystrixProperty  超时3秒也是走备用方法paymentInfo_TimeOutHandler
    public String paymentInfo_TimeOut(Integer id)
    {
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费3秒";
    }

    //写备用方法或者兜底方法
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,id ,服务异常请稍后重试";
    }
}
