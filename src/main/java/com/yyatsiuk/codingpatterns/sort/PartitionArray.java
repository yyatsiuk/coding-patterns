package com.yyatsiuk.codingpatterns.sort;

import java.util.Arrays;

public class PartitionArray {

    public int partition(int[] arr, int pivot) {
        swap(arr, pivot, arr.length - 1);
        return partition(arr, 0, arr.length - 1);
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int partitionIndex = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, partitionIndex, j);
                partitionIndex++;
            }
        }

        swap(arr, partitionIndex, hi);
        return partitionIndex;
    }

    private void swap(int[] arr, int lo, int hi) {
        int tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
    }

    public static void main(String[] args) {
        PartitionArray solution = new PartitionArray();
        int[] array = {9, 12, 5, 10, 14, 3, 10};
        int pivotIndex = solution.partition(array, 3);
        System.out.println(Arrays.toString(array));
        System.out.println(pivotIndex);
    }

}
