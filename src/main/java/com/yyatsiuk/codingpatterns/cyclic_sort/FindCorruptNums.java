package com.yyatsiuk.codingpatterns.cyclic_sort;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/N7Vw2GBQr6D">Find the Corrupt Pair</a>
 * <p>
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 * The array originally contained all the numbers from 1 to ‘n’,
 * but due to a data error, one of the numbers got duplicated which also resulted in one number going missing.
 * Find both these numbers.
 * <p>
 * <b>Example 1:</b>
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 * <p>
 * <b>Example 2:</b>
 * Input: [3, 1, 2, 3, 6, 4]
 * Output: [3, 5]
 * Explanation: '3' is duplicated and '5' is missing.
 */
public class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return new int[]{nums[i], i + 1};

        return new int[]{-1, -1};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[]{3, 1, 2, 5, 2});
        System.out.println(nums[0] + ", " + nums[1]);
        int[] nums2 = FindCorruptNums.findNumbers(new int[]{3, 1, 2, 3, 6, 4});
        System.out.println(nums2[0] + ", " + nums2[1]);
    }

}
