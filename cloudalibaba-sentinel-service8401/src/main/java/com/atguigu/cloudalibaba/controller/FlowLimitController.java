package com.atguigu.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/hotKey")
    @SentinelResource(value = "s_hotkey",blockHandler = "deal_testHotKey")
    //@SentinelResource定义兜底方法 s_hotkey定义唯一值就可以，deal_testHotKey：下面兜底方法
    //如果不写blockHandler，则使用默认的错误页面
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                              @RequestParam(value = "p2",required = false)String p2){
      //  int a=10/0;//这个是运行时的异常，sentinel不管,直接抛出异常
        return " test hotKey";
    }
    //兜底方法参数要和testHotKey方法参数后面要多一个blockException
    public String deal_testHotKey(String p1, String p2, BlockException be){
        return "兜底的方法";
    }


}
