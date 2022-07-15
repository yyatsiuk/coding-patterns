package com.yyatsiuk.codingpatterns.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">907. Sum of Subarray Minimums</a>
 */
public class SumOfSubarrayMinimums {

    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        final int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        Arrays.fill(nextLess, n);

        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[monoStack.peek()] >= arr[i]) {
                nextLess[monoStack.pop()] = i;
            }

            prevLess[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;

            sum += arr[i] * left * right;
            sum %= MOD;
        }

        return (int) (sum % MOD);
    }

    public int sumSubarrayMinsCompact(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > (i == n ? Integer.MIN_VALUE : arr[i])) {
                int mid = stack.pop();
                long left = stack.isEmpty() ? -1 : stack.peek();
                sum += (arr[mid] * (i - mid) * (mid - left));
                sum %= MOD;
            }

            stack.push(i);
        }

        return (int) sum;
    }


    public static void main(String[] args) {
        SumOfSubarrayMinimums test = new SumOfSubarrayMinimums();
        int result = test.sumSubarrayMins(new int[]{3, 1, 2, 4});
        System.out.println(result);
    }

}
