package com.atguigu.alibabacloud.service;

import com.atguigu.alibabacloud.domain.CommonResult;
import org.apache.ibatis.annotations.Param;
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
public interface StorageService {

    void decrease( Long productId,  Integer count);
}
