package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">713. Subarray Product Less Than K</a>
 * <p>
 * Given an array of integers nums and an integer k,
 * return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * <p>
 * <b>Example 2:</b>
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 */
@Slf4j
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int prod = 1;
        int result = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            result += right - left + 1;
        }
        return result;
    }


    public static void main(String[] args) {
        log.info("Result = {}", SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{2, 5, 3, 10}, 30));
        log.info("Result = {}", SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{8, 2, 6, 5}, 50));
    }


}
