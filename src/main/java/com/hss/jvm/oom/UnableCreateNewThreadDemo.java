package com.hss.jvm.oom;

import java.util.concurrent.TimeUnit;

/**
 * unable to create new native thread
 * 不能创建新的线程
 * 【谨慎运行，会导致电脑死机】
 */
public class UnableCreateNewThreadDemo {

    public static void main(String[] args) {
//        无限循环
        for (int i = 1; ; i++) {
//            创建新的线程，同时阻塞
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
