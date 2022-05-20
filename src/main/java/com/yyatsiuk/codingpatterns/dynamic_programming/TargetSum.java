package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/target-sum/">494. Target Sum</a>
 */
public class TargetSum {

    public int findTargetSubsets(int[] nums, int s) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        Integer[][] memo = new Integer[nums.length][2 * total + 1];
        return findTargetSubsets(0, 0, s, nums, memo, total);
    }

    private int findTargetSubsets(int currentIndex, int sum, int targetSum, int[] nums, Integer[][] memo, int total) {
        if (currentIndex == nums.length) {
            return sum == targetSum ? 1 : 0;
        }

        if (memo[currentIndex][sum + total] == null) {
            memo[currentIndex][sum + total] = findTargetSubsets(currentIndex + 1, sum + nums[currentIndex], targetSum, nums, memo, total) +
                    findTargetSubsets(currentIndex + 1, sum - nums[currentIndex], targetSum, nums, memo, total);
        }

        return memo[currentIndex][sum + total];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }

}
