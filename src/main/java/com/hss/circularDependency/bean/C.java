package com.hss.circularDependency.bean;

public class C {

    private A a;

    public C(){
        super();
    }

//    构造器注入
    public C(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

//    set方法注入
    public void setA(A a) {
        this.a = a;
    }
}
