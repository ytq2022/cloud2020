package com.atguigu.springcloud.entyies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @create by  ytq
 * @Date 2022/3/3  21:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {
    private Long id;
    private String serial;


}
