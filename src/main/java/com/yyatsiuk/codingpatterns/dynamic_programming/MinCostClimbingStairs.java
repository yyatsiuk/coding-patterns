package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">746. Min Cost Climbing Stairs</a>
 */
public class MinCostClimbingStairs {

    public int minCost(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int res = minCostClimbingStairs.minCost(new int[]{1, 100, 1, 1});
        System.out.println("res = " + res);
    }
}
