package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.Objects;

/**
 * Write a function that takes in a targetSum and an array of numbers as argument.
 * The function should return a boolean indication whether it is possible to generate the targetSum
 * using numbers from the array
 */
public class CanSumToTarget {

    public boolean canSum(int target, int[] nums) {
        Boolean[] memo = new Boolean[target + 1];
        return canSum(target, memo, nums);
    }

    private boolean canSum(int target, Boolean[] memo, int[] nums) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }

        if (memo[target] != null) {
            return memo[target];
        }

        for (int num : nums) {
            memo[target] = canSum(target - num, memo, nums);
            if (Objects.equals(Boolean.TRUE, memo[target])) {
                return true;
            }

        }

        memo[target] = false;
        return memo[target];
    }


    public static void main(String[] args) {
        CanSumToTarget test = new CanSumToTarget();
        System.out.println("test.canSum(7, new int[]{1, 3, 5, 2}) = " + test.canSum(7, new int[]{1, 3, 5, 2}));
        System.out.println("test.canSum(5, new int[]{4, 3, 2, 2}) = " + test.canSum(5, new int[]{4, 3, 2, 2}));
        System.out.println(test.canSum(11, new int[]{4, 3, 2, 2}));
        System.out.println(test.canSum(30000, new int[]{7, 14}));

    }
}
