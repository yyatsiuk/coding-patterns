package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/">581. Shortest Unsorted Continuous Subarray</a>
 * <p>
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order.
 * Return the shortest such subarray and output its length.
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * <b>Example 2:</b>
 * Input: nums = [1,2,3,4]
 * Output: 0
 */
@Slf4j
public class ShortestWindowSort {

    public static int sort(int[] arr) {
        if (arr.length == 1)
            return 0;

        int low = 0;
        int high = arr.length - 1;

        while (low < arr.length - 1 && arr[low] <= arr[low + 1])
            low++;

        if (low == arr.length - 1)
            return 0;

        while (high > 0 && arr[high] >= arr[high - 1])
            high--;

        int subArrMin = Integer.MAX_VALUE;
        int subArrMax = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            subArrMin = Math.min(arr[i], subArrMin);
            subArrMax = Math.max(arr[i], subArrMax);
        }

        while (low > 0 && arr[low - 1] > subArrMin) {
            low--;
        }

        while (high < arr.length - 1 && arr[high + 1] < subArrMax) {
            high++;
        }

        return high - low + 1;
    }

    public static void main(String[] args) {
        log.info("Result = {}", sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        log.info("Result = {}", sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        log.info("Result = {}", sort(new int[]{1, 2, 3}));
        log.info("Result = {}", sort(new int[]{3, 2, 1}));
    }
}
