package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/">152. Maximum Product Subarray</a>
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int maxTmp = Math.max(curr, Math.max(curr * min, curr * max));
            min = Math.min(curr, Math.min(curr * min, curr * max));

            max = maxTmp;

            result = Math.max(max, result);
        }

        return result;
    }

}
