package com.hss.juc.blockingQueue.bean;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedItem implements Delayed {

    /** 名称 */
    private String name;
    /** 触发时间 */
    private Long time;

    public DelayedItem(String name, Long time, TimeUnit unit) {
        this.name = name;
        this.time = System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
    }

    /**
     * 返回剩余的有效时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 比较两个item的大小
     * 先失效的返回-1 后失效的返回1
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        DelayedItem item = (DelayedItem) o;
        return this.time - item.time <= 0 ? -1 : 1;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DelayedItem{" +
                "time=" + time +
                ", name='" + name + '\'' +
                '}';
    }
}
