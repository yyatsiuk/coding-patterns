package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/>62. Unique Paths</a>
 */
public class UniquePaths {

    /**
     * Time complexity: O(N×M)
     * Space complexity: O(N×M)
     */
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }

        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return uniquePathsTopDown(0, 0, memo, m, n);
    }

    private int uniquePathsTopDown(int row, int col, Integer[][] memo, int m, int n) {
        if (row == (m - 1) && col == (n - 1)) {
            return 1;
        }
        if (row >= m || col >= n) {
            return 0;
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        memo[row][col] = uniquePathsTopDown(row + 1, col, memo, m, n) + uniquePathsTopDown(row, col + 1, memo, m, n);

        return memo[row][col];
    }

}
