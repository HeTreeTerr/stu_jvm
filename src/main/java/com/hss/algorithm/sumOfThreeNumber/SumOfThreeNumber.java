package com.hss.algorithm.sumOfThreeNumber;

import java.util.*;

/**
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还
 * 满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * </p>
 *
 * @author Hss
 * @date 2024-05-13
 */
public class SumOfThreeNumber {

    public static void main(String[] args) {

        int[] nums = new int[] {-1, -1, 0, 9, 2, 0, 0, 0};
        //int[] nums = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        //System.out.println(threeSum01(nums).toString());

        System.out.println(threeSum02(nums).toString());
    }

    /**
     * 方法二：暴力法
     * 时间复杂度：O（n^2）
     * 结论：不可行，map结构，存在可能性丢失、可能性重复等问题
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum02(int[] nums) {
        //定义返回list
        List<List<Integer>> resList = new ArrayList<>();
        //临时空间
        Map<Integer,List<Integer>> tempList = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer thatNum = -nums[i];
            if(tempList.containsKey(thatNum)){
                List<Integer> itemList = new ArrayList<>(tempList.get(thatNum));
                itemList.add(nums[i]);
                resList.add(itemList);
                continue;
            }
            if(i < nums.length-1){
                //System.out.println(nums[i] + "------------");
                for (int j = i+1; j < nums.length; j++){
                    //System.out.println(nums[i] + "--" + nums[j]);
                    Integer newNum = nums[i] + nums[j];
                    if(!tempList.containsKey(newNum)){
                        List<Integer> itemList = Arrays.asList(nums[i], nums[j]);
                        tempList.put(newNum,itemList);
                    }
                }
            }
        }
        return resList;
    }

    /**
     * 方法一：暴力法
     * 时间复杂度：O（n^3）
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum01(int[] nums) {
        //定义返回list
        List<List<Integer>> resList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        //核心计算
        for(int i = 0; i < nums.length - 2; i++){
            //System.out.println(i);
            for(int j = i+1; j < nums.length - 1; j++){
                //System.out.println(j);
                for(int k = j+1; k < nums.length; k++){
                    //System.out.println(k);
                    //System.out.println(nums[i] + "|" + nums[j] + "|" + nums[k]);
                    List<Integer> itemList = Arrays.asList(nums[i],nums[j],nums[k]);
                    Collections.sort(itemList);
                    String itemSet = itemList.get(0) + "|" + itemList.get(1) + "|" + itemList.get(2);
                    if((itemList.get(0) + itemList.get(1) + itemList.get(2)) == 0
                            && !set.contains(itemSet)){
                        resList.add(itemList);
                        set.add(itemSet);
                    }
                }
            }
        }
        return resList;
    }
}
