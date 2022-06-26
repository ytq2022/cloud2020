package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entyies.CommonRuslt;
import com.atguigu.springcloud.entyies.Payment;
import com.atguigu.springcloud.lb.MyLb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @create by  ytq
 * @Date 2022/3/7  20:27
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
   // private final static String PAYMENT_URL="http://localhost:8001";
    //使用eureka中的暴露的服务名称
    private final static String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @GetMapping("/consumer/create")
    public CommonRuslt<Payment> create(Payment payment){
        log.info("======= create ====");
        log.info(payment.getSerial()+":"+payment.getId());
        return this.restTemplate.postForObject(PAYMENT_URL+"/payment/createPayment",payment,CommonRuslt.class);

    }

    @GetMapping("/consumer/get/{id}")
    public CommonRuslt<Payment> queryPayment(@PathVariable("id")Long id ){
        log.info("=======querympayme=====");
        return this.restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonRuslt.class);
    }



    @GetMapping("/consumer/getForEntity/{id}")
    public CommonRuslt<Payment> queryPayment2(@PathVariable("id")Long id ){
        log.info("=======querympayme=====");
        ResponseEntity<CommonRuslt> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonRuslt.class);
        if (entity.getStatusCode().is2xxSuccessful()) {//200 之类的编码，成功返回
            return entity.getBody();
        }else {
            return new CommonRuslt<>(444,"操作错误");
        }

    }

    @Resource
    private MyLb myLb;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/getPaymentPort")
   public CommonRuslt<String> getPaymentPort(){
       List<ServiceInstance> instanceList = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
       if ( instanceList ==null ||instanceList.size() ==0)return null;

       ServiceInstance instance = myLb.getServiceInstance(instanceList);
       URI uri = instance.getUri();
       String forObject = this.restTemplate.getForObject(uri + "/payment/getPaymentPort", String.class);
      return new CommonRuslt<>(444,"成功",forObject);

   }

}
