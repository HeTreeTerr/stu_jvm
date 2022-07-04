package com.hss.stuDefault.achieve;

public interface MyInterface2 extends MyInterface1 {

    static void getName(){
        System.out.println("interface2 name");
    };

    default void getAge(){
        System.out.println("interface2 age");
    };
}
