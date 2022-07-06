package com.hss.juc.blockingQueue;

import com.cmbc.tradeBank.netTradeClient.entity.Item;
import com.hss.juc.blockingQueue.bean.DelayedItem;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列(DelayQueue)
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        DelayQueueDemo delayQueueDemo = new DelayQueueDemo();
        //throw exception(抛出异常)

        //return special value(返回指定值)

        //always blocking(一直阻塞)
        delayQueueDemo.testAlwaysBlocking();
        //time out exit(超时退出)

    }

    /**
     * put
     * task
     * 无
     */
    public void testAlwaysBlocking(){
        DelayQueue<DelayedItem> queue = new DelayQueue();
        try {
            DelayedItem item1 = new DelayedItem("item1", 5L, TimeUnit.SECONDS);
            DelayedItem item2 = new DelayedItem("item2", 10L, TimeUnit.SECONDS);
            DelayedItem item3 = new DelayedItem("item3", 15L, TimeUnit.SECONDS);
            queue.put(item1);
            queue.put(item2);
            queue.put(item3);
            System.out.println("begin time:" + LocalDateTime.now());
            while(true){
                if(queue.size()<=0){
                    break;
                }
                DelayedItem take = queue.take();
                System.out.format("name:{%s}, time:{%s}\n",take.getName(), LocalDateTime.now());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
