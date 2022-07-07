package com.hss.algorithm.selectionStrategy;

import com.hss.algorithm.selectionStrategy.utils.SelectionStrategyUtil;

import java.util.ArrayList;

/**
 * <p>
 * 随机权重策略演示
 * </p>
 *
 * @author Hss
 * @date 2022-07-07
 */
public class RandomWeightStrategyDemo {

    public static void main(String[] args) {

        // eleA
        SelectionStrategyUtil.WeightStrategyEle strategyEleA = new SelectionStrategyUtil.WeightStrategyEle();
        strategyEleA.setObj("aaa");
        strategyEleA.setWeight(8);
        // eleB
        SelectionStrategyUtil.WeightStrategyEle strategyEleB = new SelectionStrategyUtil.WeightStrategyEle();
        strategyEleB.setObj("bbb");
        strategyEleB.setWeight(1);
        // eleC
        SelectionStrategyUtil.WeightStrategyEle strategyEleC = new SelectionStrategyUtil.WeightStrategyEle();
        strategyEleC.setObj("ccc");
        strategyEleC.setWeight(1);

        // 放入集合，等待选择
        ArrayList<SelectionStrategyUtil.WeightStrategyEle> eles = new ArrayList<>();
        eles.add(strategyEleA);
        eles.add(strategyEleB);
        eles.add(strategyEleC);

        // 计数器
        Integer anum = 0;
        Integer bnum = 0;
        Integer cnum = 0;

        // 选择并输出
        for (int i = 0; i < 200; i++) {
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
        System.out.println(anum +"-"+ bnum +"-"+ cnum);
    }
}
