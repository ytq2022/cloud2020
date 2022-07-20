package com.atguigu.alibabacloud.service.impl;
/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 14:35
 *
 **/

import com.atguigu.alibabacloud.dao.AccountDao;
import com.atguigu.alibabacloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
      //  try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }

        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
