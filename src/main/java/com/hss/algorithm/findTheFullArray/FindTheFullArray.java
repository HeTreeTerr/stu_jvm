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
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        //原始数组（入参）
        //int[] nums = new int[]{1, 2, 3};
        int[] nums = new int[]{1, 3, 1};
        System.out.println(permute(nums));
    }

    /**
     * 获取排列
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        coreRecursionCompute(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    /**
     * 核心递归计算
     * @param nums
     * @param uses
     * @param path
     * @param result
     */
    private static void coreRecursionCompute(int[] nums,boolean[] uses,List<Integer> path, List<List<Integer>> result){
        //如果path和nums元素数量相同，代表成功计算出一个结果
        if(path.size() >= nums.length){
            result.add(new ArrayList<>(path));
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
            coreRecursionCompute(nums, uses, path, result);

            //将该点位移出
            uses[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
