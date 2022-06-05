package com.yyatsiuk.codingpatterns.two_pointers;

/**
 * <a href="https://leetcode.com/problems/sort-array-by-parity/">905. Sort Array By Parity</a>
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int lo = 0;
        int hi = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[lo++] = num;
            } else {
                result[hi--] = num;
            }
        }

        return result;
    }

}
