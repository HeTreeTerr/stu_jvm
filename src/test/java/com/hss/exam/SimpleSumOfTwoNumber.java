package com.hss.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和（简单版）
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target
 * 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class SimpleSumOfTwoNumber {

    public static void main(String[] args) {
        int target = 18;
        int[] nums = new int[] {2,7,11,15};
        int[] results = twoSum2(nums,target);
        if(results != null){
            System.out.println(results[0] + "==========" + results[1]);
        }else{
            System.out.println("null");
        }
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            System.out.println(i + "---------" + nums[i]);
            int result = target - nums[i];
            if(map.containsKey(result)){
                return new int[]{map.get(result),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    /**
     * 双层循环，暴力解题
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i] + "-------------");
            for(int j=i+1; j < nums.length; j++){
                System.out.println(nums[j]);
                if(target == (nums[i] + nums[j])){
                    int[] returnNum = new int[] {i,j};
                    return returnNum;
                }
            }
        }
        return null;
    }
}
