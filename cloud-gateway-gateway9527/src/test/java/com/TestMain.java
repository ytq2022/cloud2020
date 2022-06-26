package com;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @create by  ytq
 * @Date 2022-6-10  21:33
 */
public class TestMain {
    public static void main(String[] args) {

        ZonedDateTime zdt=ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);

    }
}
