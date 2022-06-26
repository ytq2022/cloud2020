package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @create by  ytq
 * @Date 2022-5-30  20:38
 */
@Component
public class MyLb implements MyLoadBalanced {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    private final int getIndex(){
        int current,next;
        do{
            current=atomicInteger.get();
            next=current >= Integer.MAX_VALUE ?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> list) {
       if(list ==null || list.size()==0)return null;

       int index=getIndex();
       index =index % list.size();
        return list.get(index);
    }
}
