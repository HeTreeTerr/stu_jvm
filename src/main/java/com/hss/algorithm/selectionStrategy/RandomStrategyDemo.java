package com.hss.algorithm.selectionStrategy;

import com.hss.algorithm.selectionStrategy.utils.SelectionStrategyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 随机策略
 * </p>
 *
 * @author Hss
 * @date 2022-07-07
 */
public class RandomStrategyDemo {

    public static void main(String[] args) {

        List<Object> elements = new ArrayList<>();
        elements.add("aaa");
        elements.add("bbb");
        elements.add("ccc");

        // 计数器
        Integer anum = 0;
        Integer bnum = 0;
        Integer cnum = 0;

        for (int i = 0; i < 9999; i++) {

            Object curObj = SelectionStrategyUtil.randomStrategy(elements);
            System.out.println("选择结果：" + curObj);
            if(curObj.equals("aaa")){
                anum++;
            }else if(curObj.equals("bbb")){
                bnum++;
            }else if(curObj.equals("ccc")){
                cnum++;
            }
        }
        System.out.println(anum +"-"+ bnum +"-"+ cnum);
    }
}
