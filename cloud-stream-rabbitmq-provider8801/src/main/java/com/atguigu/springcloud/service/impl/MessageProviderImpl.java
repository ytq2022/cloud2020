package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @create by  ytq
 * @Date 2022-7-2  16:04
 */
@EnableBinding(Source.class)//可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息的发送管道

    @Override
    public String send() {
        String serai= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serai).build());//创建并发送消息
        System.out.println("*****************message:"+serai);
        return serai;
    }
}