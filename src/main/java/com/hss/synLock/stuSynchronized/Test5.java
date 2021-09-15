package com.hss.synLock.stuSynchronized;

import java.util.Calendar;
import java.util.Date;

/**
 * 锁粗化
 * method3，method4看起来只是锁的位置不一样，
 * 但是效率差之千里。同样执行了10000次循环
 * method3执行了一万次锁的抢占，method4只执行了一次
 */
public class Test5 {

    public static void main(String[] args) throws InterruptedException {
        Calendar startDate=Calendar.getInstance();
        Calendar endDate=Calendar.getInstance();

        startDate.setTime(new Date());
        Test5 test5 = new Test5();
        test5.method3();
        endDate.setTime(new Date());

        Long timeStart=startDate.getTimeInMillis();
        Long timeEnd=endDate.getTimeInMillis();

        Long time = (timeEnd-timeStart);//相差毫秒数

        System.out.println("耗时:" + time + "(毫秒数)");

    }

    public void method3() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            //在每次循环时，抢占Test5类的锁
            synchronized (Test5.class){
                Thread.sleep(1);
            }
        }
    }
    //锁粗化，与上面一样
    public void method4() throws InterruptedException {
        //抢占到Test5类的锁后，执行for循环。
        synchronized (Test5.class){
            for (int i = 0; i < 10000; i++) {
                Thread.sleep(1);
            }
        }
    }
}
