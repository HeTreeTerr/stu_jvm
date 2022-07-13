package com.hss.algorithm.seek;

/**
 * 二分查找
 * 给定有序数组，快速查找指定元素
 */
public class DichotomizeSeek {

    public static void main(String[] args) {

        int i = 55;
        int[] arry = {1,5,19,20,55};

        int leftIndex = 0;
        int rightIndex = arry.length;
        int res = -1;
        //todo...
        while (leftIndex <= rightIndex){
            //得到中间位置
            int middle = (rightIndex - leftIndex) / 2;
            System.out.println(leftIndex + "--" + rightIndex + "--" + middle);
            if(arry[middle] == i){//匹配到值
                res = middle;
                break;
            }else if(arry[middle] < i){//值在右边
                leftIndex = middle + 1;
            }else {//值在左边
                rightIndex = middle - 1;
            }
        }
        System.out.println(res);
    }
}
