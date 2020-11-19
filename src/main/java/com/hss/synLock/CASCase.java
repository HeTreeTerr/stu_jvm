package com.hss.synLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CASCase implements Runnable{
    //volatile保证可见性和不可重排
    private static volatile int value = 0;

    private static volatile AtomicInteger valueSyn = new AtomicInteger(0);

    public void add(){
        //高并发环境，对个线程读取value值，可能出现几个线程读取的值相同然后+1，造成修改丢失
        value++;
        //当前值加1，返回新值
        valueSyn.incrementAndGet();
    }

    @Override
    public void run() {
        add();
    }

    public static void main(String[] args) throws InterruptedException {
        //定义线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 10000; i++){//提交任务10000次
            threadPool.submit(new CASCase());
        }
        Thread.sleep(1000);
        System.out.println(value+"-----------"+valueSyn);
        //关闭线程池（继续执行队列中的任务后结束）
        threadPool.shutdown();
    }
}
