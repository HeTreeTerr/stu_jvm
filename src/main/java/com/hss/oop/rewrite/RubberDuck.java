package com.hss.oop.rewrite;

/**
 * 橡胶鸭
 * oop之重写
 */
public class RubberDuck extends Duck{

    /**
     * 飞
     */
    public void fly(){
        System.out.println("不能飞...");
    }

    /**
     * 叫
     */
    public void call(){
        System.out.println("不能叫...");
    }

    public static void main(String[] args) {
        Duck rubberDuck = new RubberDuck();
        rubberDuck.fly();
        rubberDuck.call();
        /*
        执行结果：
        不能飞...
        不能叫...
         */
    }
}
