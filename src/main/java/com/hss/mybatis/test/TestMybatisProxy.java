package com.hss.mybatis.test;

import com.hss.mybatis.mapper.UserMapper;
import com.hss.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.generator.api.MyBatisGenerator;

import java.io.IOException;
import java.io.Reader;

/**
 * Mybatis
 */
public class TestMybatisProxy {

    public static void main(String[] args) throws IOException {

        String resource = "conf.xml";
        //加载 mybatis 的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);
        //构建 sqlSession 的工厂
        SqlSessionFactory sessionFactory = new
                SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中 sql 的 sqlSession
        SqlSession session = sessionFactory.openSession();
        //执行查询返回一个唯一 user 对象的 sql
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }
}
