package com.yyatsiuk.codingpatterns.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/">442. Find All Duplicates in an Array</a>
 * <p>
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice,
 * return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * <p>
 * <b>Example 2:</b>
 * Input: nums = [1,1,2]
 * Output: [1]
 * <p>
 * <b>Example 3:</b>
 * Input: nums = [1]
 * Output: []
 */
public class FindAllDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(duplicates);
//        List<Integer> duplicates2 = findDuplicates(new int[]{1, 1, 2});
//        System.out.println(duplicates2);
//        List<Integer> duplicates3 = findDuplicates(new int[]{1});
//        System.out.println(duplicates3);
    }

}
