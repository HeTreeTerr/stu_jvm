package com.hss.circularDependency.bean;

public class A {

    private B b;

    public A(){
        super();
    }

//    构造器注入
    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

//    set方法注入
    public void setB(B b) {
        this.b = b;
    }
}
