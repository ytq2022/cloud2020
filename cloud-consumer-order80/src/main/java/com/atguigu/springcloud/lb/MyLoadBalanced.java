package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @create by  ytq
 * @Date 2022-5-30  20:37
 */
public interface MyLoadBalanced {

    ServiceInstance  getServiceInstance(List<ServiceInstance> list);

}
