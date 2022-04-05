package com.yyatsiuk.codingpatterns.cyclic_sort;

/**
 * <a href="https://leetcode.com/problems/first-missing-positive/">41. First Missing Positive</a>
 * <p>
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [1,2,0]
 * Output: 3
 * <p>
 * <b>Example 2:</b>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * <p>
 * <b>Example 3:</b>
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 */
public class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int expectedIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[expectedIndex])
                swap(nums, i, expectedIndex);
            else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{1, 2, 0}));
        System.out.println(findNumber(new int[]{3, 4, -1, 1}));
        System.out.println(findNumber(new int[]{7, 8, 9, 11, 12}));
        System.out.println(findNumber(new int[]{1, 1}));
    }

}
