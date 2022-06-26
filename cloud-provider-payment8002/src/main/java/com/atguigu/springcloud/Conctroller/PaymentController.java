package com.atguigu.springcloud.Conctroller;

import com.atguigu.springcloud.entyies.CommonRuslt;
import com.atguigu.springcloud.entyies.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @create by  ytq
 * @Date 2022/3/3  22:02
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //增加服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/createPayment")
    public CommonRuslt<Integer> createPayment(@RequestBody Payment payment){
        log.info("进入==中都未====121212121=");
        int cnt=  this.paymentService.create(payment);
        log.info("结果：===="+cnt);
        if (cnt <1) {
            return new CommonRuslt<Integer>(444,"插入失败,serverPort:"+serverPort);
        }
        return new CommonRuslt<Integer>(200,"插入成功,serverPort:"+serverPort,cnt);
    }


    @GetMapping("/get/{id}")
    public CommonRuslt queryPayment(@PathVariable("id") Long id){
        log.info("====into queryPayment======");
        Payment payment=this.paymentService.queryPaymentById(id);
        log.info("payment121:"+payment);
        if(payment==null){
            return new CommonRuslt(444,"没有查到数据,serverPort:"+serverPort,null);
        }else{
            return new CommonRuslt(200,"查询成功,serverPort:"+serverPort,payment);
        }


    }


    @GetMapping("/discover")
    public Object getServers(){
        //获取所有的服务
        List<String> services = this.discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
        //具体的实例下所有的服务
        List<ServiceInstance> instances = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }


    @GetMapping("/getPaymentPort")
    public String getPaymentPort(){
        return serverPort;
    }


    @GetMapping("/getTimeoutPort")
    public String getTimeoutPort(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
