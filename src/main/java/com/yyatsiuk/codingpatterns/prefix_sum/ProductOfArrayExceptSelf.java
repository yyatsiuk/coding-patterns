package com.yyatsiuk.codingpatterns.prefix_sum;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/solution/">238. Product of Array Except Self</a>
 */
public class ProductOfArrayExceptSelf {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        suffixProduct[nums.length - 1] = 1;
        int left = 1;
        int right = nums.length - 2;
        while (left < nums.length && right >= 0) {
            prefixProduct[left] = prefixProduct[left - 1] * nums[left - 1];
            suffixProduct[right] = suffixProduct[right + 1] * nums[right + 1];
            left++;
            right--;
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefixProduct[i] * suffixProduct[i];
        }

        return ans;
    }

    /**
     * Time: O(n)
     * Space O(1)
     */
    public int[] productExceptSelfSpaceOptimized(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int suffix = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', suffix would contain the
            // product of all elements to the right. We update suffix accordingly
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }

}
