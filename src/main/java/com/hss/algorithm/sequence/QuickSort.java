package com.hss.algorithm.sequence;

/**
 * <p>
 * 快速排序
 * </p>
 *
 * @author Hss
 * @date 2022-08-04
 */
public class QuickSort {

    public static void main(String[] args) {
        /*
        88 45 48 78 6464 154 1 - 0 left=0 right=6 pivot=0 index=1 i=1
        88 45 48 78 6464 154 1 - 1 left=0 right=6 pivot=0 index=2 j=2
        88 45 48 78 6464 154 1 - 2 left=0 right=6 pivot=0 index=3 j=3
        88 45 48 78 6464 154 1 - 3 left=0 right=6 pivot=0 index=4 j=4
        88 45 48 78 6464 154 1 - 4 left=0 right=6 pivot=0 index=4 j=5
        88 45 48 78 1 154 6464 - 5 left=0 right=6 pivot=0 index=5 j=6
        1 45 48 78 88 154 6464 - 6 left=0 right=6 pivot=0 index=5 partitionIndex=4
        todo...
         */
        QuickSort sort = new QuickSort();
        int numArr[] = {88, 45, 48, 78, 6464, 154, 1};

        int resArr[] = sort.quickSort(numArr, 0, numArr.length - 1);
        System.out.println(resArr);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
