package com.hss.algorithm.selectionStrategy.utils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 选择策略
 * </p>
 *
 * @author Hss
 * @date 2022-07-07
 */
public class SelectionStrategyUtil {

    /**
     * 轮询
     */
    public synchronized static Object pollingStrategy(List<Object> elements, AtomicInteger incrementValue){
//        1.如果增量值大于等于元素个数，至为0
        if(incrementValue.get() >= elements.size()){
            incrementValue.set(0);
        }
        Object currentObj = elements.get(incrementValue.getAndIncrement());
        System.out.println(incrementValue + "--选中的机构是:" + currentObj.toString());
        return currentObj;
    }

    /**
     * 随机
     * @param elements
     * @return
     */
    public static Object randomStrategy(List<Object> elements){
        int size = elements.size();
        int randomNum = (int) (Math.random() * size);
        Object currentObj = elements.get(randomNum);
        return currentObj;
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
}
