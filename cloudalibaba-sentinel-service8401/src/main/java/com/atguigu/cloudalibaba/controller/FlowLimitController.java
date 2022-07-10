package com.atguigu.cloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @create by  ytq
 * @Date 2022-7-10  17:46
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        /*try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "---test a---";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t testB");
        return "----test b----";
    }

    @GetMapping("/testD")
    public String testD(){
        //测试RT
        /*try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // 测试异常比例
        int a=10/0;
        log.info(Thread.currentThread().getName()+"\t testD");
        return "----test d----";
    }

    @GetMapping("/testE")
    public String testE(){
        //测试异常数

        log.info(Thread.currentThread().getName()+"\t testE");
        int a=10/0;
        return "----test e----";
    }
}
