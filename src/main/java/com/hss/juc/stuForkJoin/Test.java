package com.hss.juc.stuForkJoin;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test1();

//        test.test2();
    }

    /**
     * 使用fork-join框架求和
     */
    public void test1(){
        //开始时间
        Instant start = Instant.now();

        //这里需要一个线程池的支持
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Integer> task = new ForkJoin(0, 1000);
        // 没有返回值
        // pool.execute();

        // 有返回值
        Integer sum = pool.invoke(task);

        //结束时间
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
        System.out.println(sum);
    }

    /**
     * jdk1.8流求和
     */
    public void test2(){
        //开始时间
        Instant start = Instant.now();

        OptionalLong optionalLong = LongStream.rangeClosed(0, 10000L)
                .parallel()
                .reduce(Long::sum);

        //结束时间
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
        System.out.println(optionalLong.getAsLong());
    }
}
