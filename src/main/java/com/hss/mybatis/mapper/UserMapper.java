package com.hss.mybatis.mapper;

import com.hss.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户组件层
 */
@Mapper
public interface UserMapper {

    public User getUserById(@Param(value = "id") Integer id);
}
