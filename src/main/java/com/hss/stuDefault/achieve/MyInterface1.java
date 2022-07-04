package com.hss.stuDefault.achieve;

public interface MyInterface1 {

    static void getName(){
        System.out.println("interface1 name");
    };

    default void getAge(){
        System.out.println("interface1 age");
    };
}
