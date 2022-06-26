package com.atguigu.springcloud.controller;

        import com.atguigu.springcloud.service.PaymentService;
        import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
        import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
        import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

/**
 * @create by  ytq
 * @Date 2022-6-4  10:59
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback="payment_golbalFallBackMethod")
public class OrderHystirxController {
    @Autowired
    private PaymentService paymentService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand() //加了@DefaultProperties属性注解，并且没有写具体方法名字，就用统一全局的
    //调用服务降级的配置
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
         int a=10/0;
        return paymentService.paymentInfo_TimeOut(id);
    }

    //备份或兜底方法
    public String paymentInfo_TimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己";
    }
    //全局的方法
    public String payment_golbalFallBackMethod(){
        return "gobal 我是全局的方法 80 方法";
    }

}
