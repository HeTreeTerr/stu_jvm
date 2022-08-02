package com.hss.algorithm.sequence;

/**
 * <p>
 * 简单选择排序
 * </p>
 *
 * @author Hss
 * @date 2022-08-01
 */
public class SimpleSelectionSort {

    public static void main(String[] args) {
        /*
        15 48 99 55 66 78 -- 0
        15 48 99 55 66 78 -- 1
        15 48 99 55 66 78 -- 2
        15 48 55 99 66 78 -- 3
        15 48 55 66 99 78 -- 4
        15 48 55 66 78 99 -- 5
         */
        int[] numArr = {15, 48, 99, 55, 66, 78};
        for (int i = 0; i < numArr.length - 1; i++) {
            //System.out.println(i + "--" + numArr[i]);
            int minIndex = i;
            for(int j=i+1; j < numArr.length; j++){
                if(numArr[minIndex] > numArr[j]){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = numArr[i];
                numArr[i] = numArr[minIndex];
                numArr[minIndex] = temp;
            }
        }
        System.out.println(numArr);
    }
}
