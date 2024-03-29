package com.hss.juc.volatileStu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字，不保证原子性
 * 解决方法：
 * synchronized
 * 使用juc下的AtomicInteger
 */
public class AtomicityByVolatile implements Runnable{
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
            threadPool.submit(new AtomicityByVolatile());
        }
        //关闭线程池（继续执行队列中的任务后结束）
        threadPool.shutdown();
        //需要等待上面线程执行完成后，再用main线程获取最终的结果值
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(value+"-----------"+valueSyn);

    }
}
