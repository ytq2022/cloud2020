package com.atguigu.alibabacloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 13:16
 *
 **/
@Mapper
public interface StorageDao {
    //扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
