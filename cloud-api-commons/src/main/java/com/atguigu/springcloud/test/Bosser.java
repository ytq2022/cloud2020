package com.atguigu.springcloud.test;

import java.util.concurrent.CountDownLatch;

/**
 * @create by  ytq
 * @Date 2022/3/10  21:54
 */
public class Bosser implements Runnable {
    private CountDownLatch latch;

    public Bosser(CountDownLatch latch){
        this.latch=latch;
    }



    @Override
    public void run() {
        System.out.println(" 老板正在等所有人干完活了");
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("老板开始检查工作");


    }
}
