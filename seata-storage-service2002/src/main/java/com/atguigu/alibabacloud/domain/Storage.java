package com.atguigu.alibabacloud.domain;

import lombok.Data;

/*
 *
 *@auther  ytq
 *
 *@create 2022-7-20 13:14
 *
 **/
@Data
public class Storage {
    private Long id;
    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
