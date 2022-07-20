package com.atguigu.alibabacloud.service.impl;
/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 10:18
 *
 **/

import com.atguigu.alibabacloud.dao.OrderDao;
import com.atguigu.alibabacloud.domain.Order;
import com.atguigu.alibabacloud.service.AccountService;
import com.atguigu.alibabacloud.service.OrderService;
import com.atguigu.alibabacloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    @Override
   // @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    //开启分布式事务GlobalTransactional，name是自定义，是唯一就可以，rollbackFor遇到哪些异常要回滚
    public void create(Order order) {
        log.info("----->开始新建订单");
        //1 新建订单
        orderDao.create(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.updateStatus(order.getId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");

    }
}
