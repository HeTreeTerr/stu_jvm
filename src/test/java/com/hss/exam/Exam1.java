package com.hss.exam;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author hss
 * @Date 2020/10/13 14:50:00
 */
public class Exam1 {

    @Test
    public void test1(){
        //传值n   求 1 - 1/2 + 1/3 - 1/4 + 1/5...
        int n = 3;
        Float sum = 0F;
        String questionStem = "";
        for (int i = 1; i <= n; i++) {
            //i是整形，损失精度。
            Float j = Float.valueOf(i);
            if(j % 2 == 0){//偶数
                sum -= (1 / j);
                questionStem += "-1/"+j;
            }else{//奇数
                sum += (1 / j);
                questionStem += "+1/"+j;
            }
        }
        BigDecimal b = new BigDecimal(sum);
        //返回结果，保留小数点后4位
        System.out.println(questionStem + "=" +b.setScale(4,  BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void test2(){
        //数组去重
        Integer[] arr = {1, 5, 8, 4, 8, 9, 5, 9};
        //利用set元素不重复的特性去重
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
            set.add(arr[i]);
        }
        System.out.println();
        System.out.println("------------结果--------------");
        //再将结果转为数组
        Object[] newArr = set.toArray();
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(" "+newArr[i]);
        }
        System.out.println();
    }

    @Test
    public void test3(){
        //冒泡排序
        Integer[] arr = {5, 9, 4, 3, 7, 6};

        for(int k = arr.length - 1; k >= 0; k--){
            //如果前一个元素大于后一个元素，替换位置。将最大的元素放到末尾，并不再参与排序
            for (int i = 0; i < k; i++) {
                int j;
                if(arr[i] > arr[i+1]){
                    j = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = j;
                }
            }
        }
        System.out.println("-----------结果----------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test4(){
        //equals 和 hashcode
        /*
        1、如果两个对象equals，Java运行时环境会认为他们的hashcode一定相等。
        2、如果两个对象不equals，他们的hashcode有可能相等。
        3、如果两个对象hashcode相等，他们不一定equals。
        4、如果两个对象hashcode不相等，他们一定不equals。
         */
        Object obj = new Object();
        System.out.println(obj.equals("4396"));
        System.out.println(obj.hashCode());

        Integer i = 6;
        int j = 6;
        System.out.println(i.equals(j));
        StringBuilder stringBuilder = new StringBuilder("4396");
        "4396".equals(stringBuilder);
    }

}
