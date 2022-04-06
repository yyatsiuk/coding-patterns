package com.yyatsiuk.codingpatterns.cyclic_sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/q2LA7G0ANX0">Find the First K Missing Positive Numbers</a>
 * <p>
 * Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
 * <p>
 * <b>Example 1:</b>
 * Input: [3, -1, 4, 5, 5], k=3
 * Output: [1, 2, 6]
 * Explanation: The smallest missing positive numbers are 1, 2 and 6.
 * <p>
 * <b>Example 2:</b>
 * Input: [2, 3, 4], k=3
 * Output: [1, 5, 6]
 * Explanation: The smallest missing positive numbers are 1, 5 and 6.
 * <p>
 * <b>Example 3:</b>
 * Input: [-2, -3, 4], k=2
 * Output: [1, 2]
 * Explanation: The smallest missing positive numbers are 1 and 2.
 */
public class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();
        for (i = 0; i < nums.length && missingNumbers.size() < k; i++)
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                extraNumbers.add(nums[i]);
            }

        // add the remaining missing numbers
        for (i = 1; missingNumbers.size() < k; i++) {
            int candidateNumber = i + nums.length;
            // ignore if the array contains the candidate number
            if (!extraNumbers.contains(candidateNumber))
                missingNumbers.add(candidateNumber);
        }

        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{3, -1, 4, 5, 5}, 3));
        System.out.println(findNumbers(new int[]{2, 3, 4}, 3));
        System.out.println(findNumbers(new int[]{-2, -3, 4}, 2));
    }

}
