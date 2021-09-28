package com.hss.uuid;

import org.junit.Test;

import java.util.UUID;

/**
 * uuid
 * 获取32为随机码
 */
public class StuUuid {

    @Test
    public void testUuid(){
        String lId = UUID.randomUUID().toString().replace("-","");

        System.out.println(lId);

        System.out.println(lId.length());
    }
}

