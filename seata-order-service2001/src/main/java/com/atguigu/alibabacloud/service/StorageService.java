package com.atguigu.alibabacloud.service;

import com.atguigu.alibabacloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 10:16
 *
 **/
@FeignClient("seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
