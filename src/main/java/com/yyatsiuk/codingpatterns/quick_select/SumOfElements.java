package com.yyatsiuk.codingpatterns.quick_select;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/qVljv3Plr67">Sum of Elements</a>
 */
public class SumOfElements {

    public int findSumOfElements(int[] nums, int k1, int k2) {
        int start = quickSelect(nums, 0, nums.length - 1, k1);
        int end = quickSelect(nums, 0, nums.length - 1, k2);

        int sum = 0;
        for (int i = start + 1; i < end; i++) {
            sum += nums[i];
        }

        return sum;
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
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

    private int quickSelect(int[] arr, int lo, int hi, int k) {
        if (lo == hi) {
            return lo;
        }

        int pivot = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        swap(arr, lo, pivot);
        int partition = partition(arr, lo, hi);

        if (partition < k - 1) {
            return quickSelect(arr, partition + 1, hi, k);
        } else if (partition > k - 1) {
            return quickSelect(arr, lo, partition - 1, k);
        } else {
            return k - 1;
        }
    }

    public static void main(String[] args) {
        SumOfElements sumOfElements = new SumOfElements();
        int result = sumOfElements.findSumOfElements(new int[]{1, 3, 12, 5, 15, 11}, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = sumOfElements.findSumOfElements(new int[]{3, 5, 8, 7}, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }

}
