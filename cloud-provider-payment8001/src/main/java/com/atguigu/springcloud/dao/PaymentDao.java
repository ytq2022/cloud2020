package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entyies.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @create by  ytq
 * @Date 2022/3/3  21:55
 */
/*@Mapper*/
@Repository
public interface PaymentDao {

    public int create(Payment payment);


    public Payment queryPaymentById(Long id);


}
