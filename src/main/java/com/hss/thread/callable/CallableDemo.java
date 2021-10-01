package com.hss.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Callable
 * 相比较于Runable，有返回值，可以抛出异常
 */
public class CallableDemo {

    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        try {
            System.out.println(callableDemo.method1());

            System.out.println(callableDemo.method2());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * lamda表达式形式创建线程
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public Integer method2() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName() +
                    "------------come in callable");
            TimeUnit.SECONDS.sleep(3);
            return 4396;
        });
        new Thread(futureTask,"bb").start();
        return futureTask.get();
    }

    /**
     * 普通方式创建、启动线程
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public Integer method1() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableObj());
        new Thread(futureTask,"aa").start();
        //get()方法，在获取子线程执行结果前，主线程会一直阻塞
        return futureTask.get();
    }
}
