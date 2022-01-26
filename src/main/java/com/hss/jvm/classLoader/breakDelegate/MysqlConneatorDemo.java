package com.hss.jvm.classLoader.breakDelegate;

import java.sql.Connection;

/**
 * 打破双亲委派机制的场景：
 *  tomcat
 *  mysql 驱动
 */
public class MysqlConneatorDemo {

    public static void main(String[] args) throws Exception {
        // 加载Class到AppClassLoader（系统类加载器），然后注册驱动类
        //Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://10.10.2.11:3306/jpa";
        // 通过java库获取数据库连接
        Connection conn = java.sql.DriverManager.getConnection(url, "root", "root");

        conn.close();
    }
}
