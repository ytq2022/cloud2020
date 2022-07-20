package com.atguigu.alibabacloud.service.impl;
/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 13:21
 *
 **/

import com.atguigu.alibabacloud.dao.StorageDao;
import com.atguigu.alibabacloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info(" ------->storage-service中扣减库存开始");
      storageDao.decrease(productId,count);
       log.info("------->storage-service中扣减库存结束");
    }
}
