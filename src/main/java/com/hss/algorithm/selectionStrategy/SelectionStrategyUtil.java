package com.hss.algorithm.selectionStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 选择策略
 */
public class SelectionStrategyUtil {

    /**
     * 轮询
     */
    public synchronized static Map<String,Object> pollingStrategy(List<Object> elements, AtomicInteger incrementValue){
//        1.如果增量值大于等于元素个数，至为0
        if(incrementValue.get() >= elements.size()){
            incrementValue = new AtomicInteger(0);
        }
        AtomicInteger next = new AtomicInteger(incrementValue.incrementAndGet());
        Object currentObj = elements.get(incrementValue.decrementAndGet());
        HashMap<String, Object> map = new HashMap<>();
        map.put("next",next);
        map.put("currentObj",currentObj);
        return map;
    }


    /**
     * 权重随机
     * @param weightStrategyEles
     * @return
     */
    public static Object randomWeightStrategy(List<WeightStrategyEle> weightStrategyEles){
//        总权重数
        Integer maxNum = 0;
        for(WeightStrategyEle ele : weightStrategyEles){
            maxNum = maxNum + ele.getWeight();
        }
        if(maxNum == 0){
            return null;
        }
//        获取随机数
        int randomNum = (int) (Math.random() * maxNum + 1);

        Object currentObj = null;
        int currNum = 0;
//        给权重分段，落在那个elements的范围，就选择那一个element
        for(int i = 0; i <weightStrategyEles.size(); i++){
            currNum = currNum + weightStrategyEles.get(i).getWeight();
            if(randomNum <= currNum){
                currentObj = weightStrategyEles.get(i).getObj();
                break;
            }
        }
        return currentObj;
    }

    /**
     * 权重策略传参
     * 静态内部类
     */
    public static class WeightStrategyEle{
        private Object obj;

        private Integer weight;

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }

//    static volatile AtomicInteger incrementValue = new AtomicInteger(0);
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        测试轮询
        /*List<Object> list = new CopyOnWriteArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");*/

//        单线程
        /*for (int i = 0; i < 100; i++) {
            Map<String, Object> map = SelectionStrategyUtil.pollingStrategy(list, incrementValue);
            incrementValue = (AtomicInteger)map.get("next");
            System.out.println("选中机构=" + map.get("currentObj"));
        }*/

//        高并发
        /*ArrayList<FutureTask<Object>> futures =new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            FutureTask<Object> futureTask = new FutureTask<>(()->{
                Map<String, Object> map = SelectionStrategyUtil.pollingStrategy(list, incrementValue);
                incrementValue = (AtomicInteger)map.get("next");
                System.out.println(("选中的机构是:"+map.get("currentObj")));
                return map.get("currentObj");
            });
            executorService.execute(futureTask);
            futures.add(futureTask);
        }
        executorService.shutdown();
        for(int i = 0; i < futures.size(); i++){
            FutureTask<Object> future = futures.get(i);
        }*/


//        随机数
        /*Integer num = 50;
        for (int i = 0; i < 50; i++) {
            int randomNum = (int) (Math.random() * num);
            System.out.println(randomNum);
        }*/

//        测试权重
        /*ArrayList<WeightStrategyEle> eles = new ArrayList<>();
        WeightStrategyEle strategyEleA = new WeightStrategyEle();
        strategyEleA.setObj("aaa");
        strategyEleA.setWeight(8);
        WeightStrategyEle strategyEleB = new WeightStrategyEle();
        strategyEleB.setObj("bbb");
        strategyEleB.setWeight(1);
        WeightStrategyEle strategyEleC = new WeightStrategyEle();
        strategyEleC.setObj("ccc");
        strategyEleC.setWeight(1);

        eles.add(strategyEleA);
        eles.add(strategyEleB);
        eles.add(strategyEleC);

        Integer anum = 0;
        Integer bnum = 0;
        Integer cnum = 0;
        for (int i = 0; i < 20000; i++) {
            String element = SelectionStrategyUtil.randomWeightStrategy(eles).toString();
            System.out.println("选中机构=" + element);
            if(element.equals("aaa")){
                anum++;
            }else if(element.equals("bbb")){
                bnum++;
            }else if(element.equals("ccc")){
                cnum++;
            }
        }
        System.out.println(anum +"-"+ bnum +"-"+ cnum);*/

//    }
}
