package com.hss.mybatis.test;

import com.hss.mybatis.mapper.UserMapper;
import com.hss.mybatis.pojo.User;
import com.hss.mybatis.proxy.MapperProxy;

/**
 * 投鞭断流（只定义接口，不写实现类。根据反射和动态代理完成实现类功能）
 */
public class TestProxy {

    public static void main(String[] args) {
        MapperProxy proxy = new MapperProxy();

        UserMapper mapper = proxy.newInstance(UserMapper.class);
        User user = mapper.getUserById(1001);

        System.out.println(user);

        System.out.println(mapper.toString());
    }
}
