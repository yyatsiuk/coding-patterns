package com.yyatsiuk.codingpatterns.two_pointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-smaller/">259. 3Sum Smaller</a>
 * <p>
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 * <p>
 * <b>Example 1:</b>
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * <p>
 * <b>Example 2:</b>
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 *    [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletWithSmallerSum {

    public static int searchTriplets(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            count += searchPair(nums, target - nums[i], i);
        }

        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int left = first + 1;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int result = searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5);
        System.out.println("result = " + result);
    }
}
