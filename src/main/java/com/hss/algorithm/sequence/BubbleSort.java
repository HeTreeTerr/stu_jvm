package com.hss.algorithm.sequence;

/**
 * 冒泡排序
 * 时间复杂度
 * 最优的时间复杂度为：O( n^2 ) ;
 * 最差的时间复杂度为：O( n^2 );
 * 平均的时间复杂度为：O( n^2 );
 *
 * 空间复杂度
 * 空间复杂度就是在交换元素时那个临时变量所占的内存空间;
 * 最优的空间复杂度就是开始元素顺序已经排好了，则空间复杂度为：0;
 * 最差的空间复杂度就是开始元素逆序排序了，则空间复杂度为：O(n);
 * 平均的空间复杂度为：O(1);
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
