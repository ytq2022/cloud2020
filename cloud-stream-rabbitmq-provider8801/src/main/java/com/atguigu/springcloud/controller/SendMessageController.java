package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @create by  ytq
 * @Date 2022-7-2  16:11
 */
@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl messageProvider;

    @GetMapping("/sendMessage")
    public String send(){
        return this.messageProvider.send();
    }

}
