package com.hss.algorithm.selectionStrategy;

import com.hss.algorithm.selectionStrategy.utils.SelectionStrategyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 轮询策略演示
 * </p>
 *
 * @author Hss
 * @date 2022-07-07
 */
public class PollingStrategyDemo {

    private static volatile AtomicInteger incrementValue = new AtomicInteger(0);

    public static void main(String[] args) {

        // 定义元素并放入集合
        List<Object> list = new CopyOnWriteArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        // 单线程
        /*for (int i = 0; i < 50; i++) {

            Object currentObj = SelectionStrategyUtil.pollingStrategy(list, incrementValue);
            System.out.println(incrementValue + "--选中的机构是:" + currentObj.toString());
        }*/

        // 高并发
        ArrayList<FutureTask<Object>> futures =new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            FutureTask<Object> futureTask = new FutureTask<>(()->{
                Object currentObj = SelectionStrategyUtil.pollingStrategy(list, incrementValue);
                return currentObj;
            });
            executorService.execute(futureTask);
            futures.add(futureTask);
        }
        executorService.shutdown();
        for(int i = 0; i < futures.size(); i++){
            FutureTask<Object> future = futures.get(i);
        }

    }
}
