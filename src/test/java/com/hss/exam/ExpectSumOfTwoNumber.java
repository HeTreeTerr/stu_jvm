package com.hss.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整形数组（数组中的元素可重复），以及一个指定的值。
 * 打印出数组中两数之和为所有指定值的所有整数对
 *
 */
public class ExpectSumOfTwoNumber {

    public static void main(String[] args) {
        Integer num = 15;
        Integer[] arr = {3,7,9,1,2,8,5,6,10,5};
        function1(arr,num);
    }

    public static void function1(Integer[] arr,Integer num){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }
        System.out.println("--------list.size:" + list.size());

       /* for(Integer o1 : list){
            Integer o2 = num - o1;
            if(o2 > 0 && list.contains(o2)){
                System.out.println("o1=" + o1 + "----------o2=" + o2);
            }
        }*/
    }
}
