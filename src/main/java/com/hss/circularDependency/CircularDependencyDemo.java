package com.hss.circularDependency;

import com.hss.circularDependency.bean.A;
import com.hss.circularDependency.bean.B;
import com.hss.circularDependency.bean.C;

/**
 * 循环依赖
 *  A 依赖 B
 *  B 依赖 C
 *  C 依赖 A
 *  在创建实体是，相互等待对方实例化完成。
 */
public class CircularDependencyDemo {

    public static void main(String[] args) {
//        set方式注入
        setWay();

//        构造器注入
//        constructorWay();
    }

    public static void setWay(){
        A a = new A();
        B b = new B();
        C c = new C();
        a.setB(b);
        b.setC(c);
        c.setA(a);
        System.out.println("a=" + a + ",b=" + b + ",c=" + c);
    }

    public static void constructorWay(){
//        陷入循环，无解决方案
//        new A(new B(new C(new A())));
    }
}
