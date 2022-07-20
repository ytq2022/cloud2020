package com.atguigu.alibabacloud.dao;

import com.atguigu.alibabacloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 9:41
 *
 **/
@Mapper
public interface OrderDao {
    //1 新建订单
    long create (Order order);
    //2 修改订单状态，从零改为1
    int updateStatus(@Param("id")Long id,@Param("status") int status);
}
