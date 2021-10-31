package com.hss.exam;

import java.util.*;

/**
 * 两数求和（进阶版）
 * 给定一个整形数组（数组中的元素可重复），以及一个指定的值。
 * 打印出数组中两数之和为所有指定值的所有整数对。
 * 要求：时间复杂度为O(N)
 */
public class AdvancedSumOfTwoNumber {

    public static void main(String[] args) {
        Integer num = 15;
        Integer[] arr = {3,7,9,1,2,8,5,6,10,5};
        function2(arr,num);
    }

    /**
     * 1.给数组正向排序，时间复杂度O(NlogN)
     * 2.首尾比对，判断满足条件元素对O(N)
     * 指定left指向数组首元素,right指定数组末元素
     * left需要小于right
     * 如果num(指定值)>首尾元素和，left值加一
     * 如果num(指定值)<首尾元素和，right值减一
     * num(指定值)=首尾元素和，满足条件输出。left值加一，right值减一，继续进行比对
     * 结论：总的时间复杂度为O(NlogN)，空间复杂度为O(1)
     */
    public static void function1(Integer[] arr,Integer num){
        System.out.println("--------------function1--------------");
        //1.给数组排序
        Arrays.sort(arr);
        //2.指定数组首尾元素指针
        Integer left = 0, right = arr.length - 1;
        //3.遍历数组，根据num(指定值)和首尾元素和比对来确定范围
        while (left < right){
            if(num > (arr[left] + arr[right])){
                //如果指定值大于首尾和，left++
                left++;
            }else if(num < (arr[left] + arr[right])){
                //如果指定值小于首尾和，right--
                right--;
            }else {
                //满足条件，输出并继续比对
                System.out.println(arr[left] + " + " + arr[right] + " = " + num);
                left++;
                right--;
            }
        }
    }

    /**
     * 使用hashSet特性（无序、值不重复）
     * o2(待确认的值) = num(指定值) - o1(当前元素值)
     * 如果hashSet中不存在o2，将o1放入set中当做备选元素值
     * 否则，输出o1,o2满足条件
     */
    public static void function2(Integer[] arr,Integer num){
        System.out.println("--------------function2--------------");
        //效验数组不为空
        if(arr == null || arr.length <= 0){
            return;
        }
        //定义hashSet
        Set<Integer> intSet = new HashSet<>(arr.length);
        Integer o2;
        for (Integer o1 : arr){
            //计算出满足o1的对应值o2
            o2 = num - o1;
            if(!intSet.contains(o2)){
                intSet.add(o1);
            }else {
                System.out.println(o1 + " + " + o2 + " = " + num);
            }
        }
    }
}
