package com.hss.stuDefault;

public interface MyInterface2 extends MyInterface1 {

    static void getName(){
        System.out.println("interface2 name");
    };

    default void getAge(){
        System.out.println("interface2 age");
    };
}
