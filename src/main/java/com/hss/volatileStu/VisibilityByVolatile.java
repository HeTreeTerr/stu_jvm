package com.hss.volatileStu;

/**
 * volatile关键字，保证可见性
 */
public class VisibilityByVolatile {
    /**
     * 当计算机存在多个cpu时：
     * volatile关键字注解变量后，
     * 会绕过cpu缓存，保证每次读
     * 变量都从内存中读。
     *
     * 禁止指令重排序优化。（什么是指令重排序：
     * 是指CPU采用了允许将多条指令不按程序规定的顺序分开
     * 发送给各相应电路单元处理）。
     */
    protected volatile static Boolean flag = false;

    protected volatile static int number;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread1(),"t1").start();

        Thread.sleep(1000);

        flag = true;
        number = 4396;
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            //如果flag为false
            while (!flag){

            }
            System.out.println("----------->"+number);
        }
    }

}
