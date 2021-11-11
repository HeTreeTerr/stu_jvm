package com.hss.circularDependency.bean;

public class B {

    private C c;

    public B(){
        super();
    }

//    构造器注入
    public B(C c) {
        this.c = c;
    }

    public C getC() {
        return c;
    }

//    set方法注入
    public void setC(C c) {
        this.c = c;
    }
}
