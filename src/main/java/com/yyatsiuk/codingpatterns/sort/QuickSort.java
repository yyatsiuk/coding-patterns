package com.yyatsiuk.codingpatterns.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public int[] sortArray(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        swap(arr, lo, pivot);
        int partitionIndex = partition(arr, lo, hi);

        quickSort(arr, lo, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo;
        for (int j = lo + 1; j <= hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, lo, i);
        return i;
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] sortedArray = quickSort.sortArray(new int[]{3, 9, 1, 2, 4, 0, 10});
        System.out.println(Arrays.toString(sortedArray));
    }
}
