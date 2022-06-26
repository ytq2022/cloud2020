package com.atguigu.springcloud.service;

        import cn.hutool.core.util.IdUtil;
        import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
        import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.PathVariable;

/**
 * @create by  ytq
 * @Date 2022-6-4  22:51
 */
@Service
public class PaymentCirutServcie {
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求的次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//一个窗口的时间
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//一个窗口内错误的占的百分数
    })
//总的表示一个时间窗口(1秒内)总共有10次请求中，错误的占60%，熔断器就端口，服务就熔断
    public String paymentCircuitBreaker( Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "出现异常，请稍后再试，   id: " +id;
    }

}
