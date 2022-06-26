package com.atguigu.springcloud.test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @create by  ytq
 * @Date 2022/3/10  21:49
 */
public class Worker  implements  Runnable {
    private String name;

    private CountDownLatch latch;

    public Worker(String name,CountDownLatch latch){
        this.name=name;
        this.latch=latch;
    }


    @Override
    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" 活干完了");
        this.latch.countDown();

    }


    public void doWork(){
        System.out.println( name+" 正在干活！ ");
    }
}
