package com.hss.thread.join;

public class TestThreadJoin extends Thread {

    public void run(){
        System.out.println("子线程执行--start");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程执行--end");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主方法--start");
        TestThreadJoin testThread = new TestThreadJoin();
        testThread.start();

//        测试线程插队(mian)
        testThread.join();

        System.out.println("主方法--end");
    }
}
