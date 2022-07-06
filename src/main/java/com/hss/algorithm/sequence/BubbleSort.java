package com.hss.algorithm.sequence;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arrays = {2,45,18,65,89,41,55,36};

        //每一轮比较，将最大的值筛选出来放到最后
        for (int i = 0; i < arrays.length-1; i++) {
            //此次循环，最大值已经选出。将单次遍历的元素数减一，提高效率
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if(arrays[j] > arrays[j+1]){
                    Integer temp;
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                }
            }
        }
        System.out.println("\n==========结果==========");
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
