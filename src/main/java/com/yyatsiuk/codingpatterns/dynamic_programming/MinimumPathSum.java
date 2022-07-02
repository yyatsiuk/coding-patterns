package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/">64. Minimum Path Sum</a>
 */
public class MinimumPathSum {

    public int minPathSumTopDown(int[][] grid) {
        Integer[][] memo = new Integer[grid.length][grid[0].length];
        return minPathSumTopDown(grid, 0, 0, memo);
    }

    private int minPathSumTopDown(int[][] grid, int i, int j, Integer[][] memo) {
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];

        if (memo[i][j] != null) return memo[i][j];

        int sum1 = minPathSumTopDown(grid, i + 1, j, memo);
        int sum2 = minPathSumTopDown(grid, i, j + 1, memo);
        memo[i][j] = grid[i][j] + Math.min(sum1, sum2);
        return memo[i][j];
    }

    // O(n*m)
    private int minPathSumBottomUp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dp[m][n - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int res = minimumPathSum.minPathSumBottomUp(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(res);

    }
}
