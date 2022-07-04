package com.yyatsiuk.codingpatterns.prefix_sum;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">560. Subarray Sum Equals K</a>
 * <p>
 * Given an array of integers nums and an integer k, return the total number of  subarrays whose sum equals to k.
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * <b>Example 2:</b>k
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int num : nums) {
            // current prefix sum
            currSum += num;

            // situation 1:
            // continuous subarray starts
            // from the beginning of the array
            if (currSum == k)
                count++;

            // situation 2:
            // number of times the curr_sum − k has occurred already,
            // determines the number of times a subarray with sum k
            // has occurred upto the current index
            count += h.getOrDefault(currSum - k, 0);

            // add the current sum
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int result = subarraySum(new int[]{5, 0, 2, 3, 1}, 5);
        System.out.println(result);
    }

}
