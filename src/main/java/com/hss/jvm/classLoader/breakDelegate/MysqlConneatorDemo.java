package com.hss.jvm.classLoader.breakDelegate;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 打破双亲委派机制的场景：
 *  tomcat
 *  mysql 驱动
 */
public class MysqlConneatorDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("\n===========相关类的类加载器==========");
        System.out.println(com.mysql.jdbc.Driver.class.getClassLoader());
        System.out.println(java.sql.DriverManager.class.getClassLoader());
        System.out.println(java.sql.Driver.class.getClassLoader());

        /*System.out.println("\n===========获取connection连接==========");
        // 加载Class到AppClassLoader（系统类加载器），然后注册驱动类
        //Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://127.0.0.1:3306/edit-demo";
        // 通过java库获取数据库连接
        Connection conn = java.sql.DriverManager.getConnection(url, "root", "root");

        System.out.println("\n===========关闭connection连接==========");
        if(conn != null){
            conn.close();
        }
        conn = null;*/

    }
}
