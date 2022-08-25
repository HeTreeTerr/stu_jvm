package com.hss.algorithm.sortedArrayToBST;

/**
 * <p>
 * 数组转换为二叉树
 * </p>
 *
 * @author Hss
 * @date 2022-08-25
 */
public class SortedArrayToBSTDemo {

    public static void main(String[] args) {

        SortedArrayToBSTDemo demo = new SortedArrayToBSTDemo();
        //定义数组 param（自带自增属性）
        int[] arr = {-10, -3, 0, 5, 9};
        //实现转换
        TreeNode tree = demo.sortedArrayToBST(arr);
        System.out.println(tree);
    }

    /**
     * 核心实现
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    /**
     * left:0 right:4 -> mid:2 == node:0
     *  左:left:0 right:1 -> mid:0 == node:-10
     *      左:left:0 right:-1 -> null
     *      右:left:1 right:1 -> mid:1 == -3
     *  右:left:3 right:4 -> mid:3 == node:5
     *      左:left:3 right:2 -> null
     *      右:left:4 right:4 -> mid:4 == 9
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


    /**
     * 树元素节点实体类
     * 内部类
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
