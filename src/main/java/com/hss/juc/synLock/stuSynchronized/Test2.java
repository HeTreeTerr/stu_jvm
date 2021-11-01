package com.hss.juc.synLock.stuSynchronized;

public class Test2 implements Runnable{

    private static int i = 0;

    private synchronized void add(){
        i++;
    }

    @Override
    public void run() {
        for (int i=0;i<10000;++i){
            add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Test2());
        Thread thread2 = new Thread(new Test2());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}
