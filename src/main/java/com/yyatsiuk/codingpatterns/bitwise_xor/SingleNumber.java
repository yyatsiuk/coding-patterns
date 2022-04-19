package com.yyatsiuk.codingpatterns.bitwise_xor;

/**
 * <a href="https://leetcode.com/problems/single-number/">136. Single Number</a>
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

}
