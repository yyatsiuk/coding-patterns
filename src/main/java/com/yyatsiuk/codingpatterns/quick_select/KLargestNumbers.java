package com.yyatsiuk.codingpatterns.quick_select;

import java.util.concurrent.ThreadLocalRandom;

public class KLargestNumbers {

    public int findKthLargestQuickSelectSolution(int[] nums, int k) {
        return kLargest(nums, k, 0, nums.length - 1);
    }

    private int kLargest(int[] arr, int k, int lo, int hi) {
        if (lo >= hi) {
            return arr[lo];
        }

        int pivot = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        swap(arr, lo, pivot);
        int partition = partition(arr, lo, hi);

        if (partition < k - 1) {
            return kLargest(arr, k, partition + 1, hi);
        } else if (partition > k - 1) {
            return kLargest(arr, k, lo, partition - 1);
        } else {
            return arr[k - 1];
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo;
        for (int j = i + 1; j <= hi; j++) {
            if (arr[j] > pivot) {
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

}
