package com.hss.generic;

/**
 * 泛型类
 * 语法：类名<T>
 * T是类型占位符，表示一种引用类型，如果编写多个使用逗号隔开
 */
public class MyGeneric<T> {

    //使用泛型T
    //1.创建变量
    T t;

    public MyGeneric(T t) {
        this.t = t;
    }

    //2.添加方法
    public void show(T t){
        System.out.println(t);
    }

    //3.发型作为方法返回值
    public T getT(){
        return t;
    }
}
