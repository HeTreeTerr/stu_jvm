package com.hss.volatileStu;

public class VolatileTest extends Thread{
    //不加volatile关键字，主方法执行后不会停止
    //加上关键字后，主方法修改flag的值后，Thread线程立刻感受到变化，提示线程
    private volatile static Boolean flag = false;

    @Override
    public void run() {
        while (!flag){

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new VolatileTest().start();
        Thread.sleep(2000);
        flag = true;
    }
}
