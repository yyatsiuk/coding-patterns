package com.yyatsiuk.codingpatterns.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sum-of-subarray-ranges/">2104. Sum of Subarray Ranges</a>
 */
public class SumOfSubarrayRanges {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long[] minLeft = new long[n];
        long[] minRight = new long[n];
        Arrays.fill(minRight, n);

        long[] maxLeft = new long[n];
        long[] maxRight = new long[n];
        Arrays.fill(maxRight, n);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                minRight[stack.pop()] = i;
            }

            minLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxRight[stack.pop()] = i;
            }

            maxLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long minLeftSize = i - minLeft[i];
            long minRightSize = minRight[i] - i;

            long maxLeftSize = i - maxLeft[i];
            long maxRightSize = maxRight[i] - i;

            sum = sum + ((nums[i] * maxLeftSize * maxRightSize) - (nums[i] * minLeftSize * minRightSize));
        }

        return sum;
    }

}
