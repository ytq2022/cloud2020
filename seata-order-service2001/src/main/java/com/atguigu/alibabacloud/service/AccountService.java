package com.atguigu.alibabacloud.service;

import com.atguigu.alibabacloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 10:14
 *
 **/
@FeignClient("seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
