package com.atguigu.springcloud.entyies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create by  ytq
 * @Date 2022/3/3  21:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRuslt<T> {
    private Integer code;

    private  String message;

    private T data;

    public CommonRuslt(Integer code,String message){

        this(code,message,null);
    }


}
