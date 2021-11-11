package com.hss.uuid;

import java.util.UUID;

/**
 * uuid
 * 获取32为随机码
 */
public class StuUuid {

    public static void main(String[] args) {
        String lId = UUID.randomUUID().toString().replace("-","");

        System.out.println(lId);

        System.out.println(lId.length());
    }
}

