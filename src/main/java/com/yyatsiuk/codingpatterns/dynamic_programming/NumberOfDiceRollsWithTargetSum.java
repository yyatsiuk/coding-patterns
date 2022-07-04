package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/">1155. Number of Dice Rolls With Target Sum</a>
 */
public class NumberOfDiceRollsWithTargetSum {

    private static final int MOD = 1000000007;

    public int numRollsToTargetTopDown(int n, int k, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return numRollsToTargetTopDown(n, k, target, memo);
    }

    public int numRollsToTargetTopDown(int n, int k, int target, Map<String, Integer> memo) {
        if (n == 0 && target == 0) return 1;
        if (n == 0 || target == 0) return 0;

        String memoKey = n + " " + target;
        if (memo.containsKey(memoKey)) return memo.get(memoKey);

        int res = 0;
        for (int num = 1; num <= k; num++) {
            if (target >= num) {
                res = (res + numRollsToTargetTopDown(n - 1, k, target - num, memo)) % MOD;
            } else {
                break;
            }
        }

        memo.put(memoKey, res);
        return res;
    }

    public int numRollsToTargetBottomUp(int n, int k, int target) {
        if (target > n * k) {
            return 0;
        }
        int mod = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }

}
