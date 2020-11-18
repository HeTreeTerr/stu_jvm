package com.hss.demo1;

/**
 * 线程死锁
 */
public class Demo1_7 {
    static A a= new A();
    static B b= new B();

    public static void main(String[] args) throws InterruptedException {
        new Thread(null,()->{
            //1.锁定a对象
            synchronized (a){
                try {
                    //睡眠两秒
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //5.线程0继续运行，尝试锁定对象b.单对象b被线程1锁定。【结果导致线程0和1互相等待，造成死锁】
                synchronized (b){
                    System.out.println("我获得了a和b");
                }
            }
        },"Thread-0").start();
        //2.等待一秒
        Thread.sleep(1000);

        new Thread(null,()->{
            //3.锁定对象b
            synchronized (b){
                //4.锁定对象a,单此时对象a被线程锁定。故1等待0释放对象a
                synchronized (a){
                    System.out.println("我获得了a和b");
                }
            }
        },"Thread-1").start();
    }
}

class A{}
class B{}
