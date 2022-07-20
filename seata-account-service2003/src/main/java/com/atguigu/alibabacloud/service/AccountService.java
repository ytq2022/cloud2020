package com.atguigu.alibabacloud.service;
/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 14:34
 *
 **/

import java.math.BigDecimal;

public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
