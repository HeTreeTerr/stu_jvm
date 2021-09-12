package com.hss.volatileStu;

/**
 * volatile关键字，禁止指令重排
 * 高并发下，看程序心情，无法回显
 */
public class OrderSortByVolatile {

    int a = 0;

    boolean flag = false;

    public void method1(){
//        语句1
        a = 1;
//        语句2
        flag = true;
    }

    public void method2(){
        if(flag){
//            语句三
            a = a + 5;
            System.out.println("------->retValue:" + a);
        }
    }

    public static void main(String[] args) {
        OrderSortByVolatile sort = new OrderSortByVolatile();
//        单线程下，a最终等于6
        sort.method1();
        sort.method2();

        /**
         * 多线程下，如果指令重排（语句1和语句2顺序互换）
         * //        语句2
         *         flag = true;
         * //        语句1
         *         a = 1;
         *
         * t1线程执行完method1语句2，没有执行到语句1
         * t2线程执行method2方法，输出a=5
         *
         * 如果a和flag用volatile修饰，禁止指令重排则可以避免
         */
    }
}
