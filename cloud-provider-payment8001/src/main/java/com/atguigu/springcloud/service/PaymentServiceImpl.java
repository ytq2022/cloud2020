package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entyies.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @create by  ytq
 * @Date 2022/3/3  22:01
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return this.paymentDao.create(payment);
    }

    @Override
    public Payment queryPaymentById(Long id) {
        return this.paymentDao.queryPaymentById(id);
    }
}
