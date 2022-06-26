package com.atguigu.springcloud.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @create by  ytq
 * @Date 2022/3/10  21:58
 */
public class DemoTest {

    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);
        Worker w1=new Worker("张三",latch);
        Worker w2=new Worker("李四",latch);
        Worker w3=new Worker("王五",latch);
        Bosser bosser=new Bosser(latch);

        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("=========start==========");

//        service.execute(w1);
//        service.execute(w2);
//        service.execute(bosser);
//        service.execute(w3);
//
        service.submit(w1);
        service.submit(w2);
        service.submit(w3);
        service.submit(bosser);

        System.out.println("==========end=========");

        service.shutdown();
        System.out.println(" shutdown");

    }
}
