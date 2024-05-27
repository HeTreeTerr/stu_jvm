package com.hss.algorithm.findTheFullArray;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 定义一个数组，获取数组所有可能的排列
 * </p>
 *
 * @author Hss
 * @date 2024-05-27
 */
public class FindTheFullArray {

    /**
     * 定义集合res接收结果集
     */
    private final static List<List<Integer>> RES = new ArrayList<>();

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        //原始数组（入参）
        int[] nums = new int[]{1, 2, 3};
        permutation(nums);
        System.out.println(RES);
    }

    /**
     * 获取排列
     * @param nums
     */
    private static void permutation(int[] nums){
        coreRecursionCompute(nums, new boolean[nums.length], new ArrayList<>());
    }

    /**
     * 核心递归计算
     */
    private static void coreRecursionCompute(int[] nums,boolean[] uses,List<Integer> path){
        //如果path和nums元素数量相同，代表成功计算出一个结果
        if(path.size() >= nums.length){
            RES.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //如果该点位已经被使用过，跳过
            if(uses[i]){
                continue;
            }
            //将该点位放入计算中
            uses[i] = true;
            path.add(nums[i]);

            //递归运算
            coreRecursionCompute(nums, uses, path);

            //将该点位移出
            uses[i] = false;
            path.remove(new Integer(nums[i]));
        }
    }
}
