package com.hss.stuDefault;

import com.hss.stuDefault.achieve.MyInterface2;
import com.hss.stuDefault.inherit.AbstractClass;

public class DefaultTest implements MyInterface2 {

    public static void main(String[] args) {
//        interface static使用
//        MyInterface1.getName();
        MyInterface2.getName();

//        interface default使用
        MyInterface2 myInterface2 = new DefaultTest();
        myInterface2.getAge();
    }

    /*@Override
    public void getAge() {
        System.out.println("impl age");
    }*/
}
