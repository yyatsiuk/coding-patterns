package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * <b>Example 2:</b>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
@Slf4j
public class SortedArraySquares {

    public static int[] makeSquares(int[] nums) {
        int[] squares = new int[nums.length];
        int headPointer = 0;
        int tailPointer = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int num1 = Math.abs(nums[headPointer]);
            int num2 = Math.abs(nums[tailPointer]);
            if (num1 > num2) {
                squares[i] = num1 * num1;
                headPointer++;
            } else {
                squares[i] = num2 * num2;
                tailPointer--;
            }
        }

        return squares;
    }

    public static void main(String[] args) {
        log.info("Result = {}", Arrays.toString(makeSquares(new int[]{-3, -1, 0, 1, 2})));
    }

}
