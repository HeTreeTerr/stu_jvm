package com.hss.juc.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableObj implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() +
                "------------come in callable");
        TimeUnit.SECONDS.sleep(3);
        return 4396;
    }
}
