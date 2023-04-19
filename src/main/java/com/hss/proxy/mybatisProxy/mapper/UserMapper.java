package com.hss.proxy.mybatisProxy.mapper;

import com.hss.proxy.mybatisProxy.pojo.User;

import java.util.Map;

/**
 * 用户组件层
 */
public interface UserMapper {

    User getUserById(Integer id);

    User findUserOrderBy(Map<String,Object> paramMap);
}
