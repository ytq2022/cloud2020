package com.atguigu.alibabacloud.controller;

import com.atguigu.alibabacloud.domain.CommonResult;
import com.atguigu.alibabacloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 13:26
 *
 **/
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
   public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功！");
    };

}
