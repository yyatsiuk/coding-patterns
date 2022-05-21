package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">322. Coin Change</a>
 */
public class MinimumCoinChange {

    /**
     * Time: O(A * n)
     * Space: O(A)
     */
    public int coinChangeTopDown(int[] coins, int amount) {
        if (amount == 0) return 0;
        Integer[][] memo = new Integer[coins.length][amount + 1];
        int res = coinChangeTopDown(0, amount, coins, memo);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int coinChangeTopDown(int index, int amount, int[] coins, Integer[][] memo) {
        if (amount == 0) return 0;
        if (index >= coins.length) return Integer.MAX_VALUE;

        if (memo[index][amount] == null) {
            int c1 = Integer.MAX_VALUE;
            if (coins[index] <= amount) {
                int res = coinChangeTopDown(index, amount - coins[index], coins, memo);
                if (res != Integer.MAX_VALUE) {
                    c1 = res + 1;
                }
            }
            int c2 = coinChangeTopDown(index + 1, amount, coins, memo);
            memo[index][amount] = Math.min(c1, c2);
        }

        return memo[index][amount];
    }

    // https://backtobackswe.com/platform/content/the-change-making-problem/video
    public int coinChangeBottomUp(int[] coins, int amount) {
        // This table will store the answer to our sub problems
        int[] dp = new int[amount + 1];

        // Initialize the dp table
        Arrays.fill(dp, amount + 1);

    /*
      The answer to making change with minimum coins for 0
      will always be 0 coins no matter what the coins we are
      given are
    */
        dp[0] = 0;

        // Solve every subproblem from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // For each coin we are given
            for (int coin : coins) {
                // If it is less than or equal to the sub problem amount
                if (coin <= i) {
                    // Try it. See if it gives us a more optimal solution
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

    /*
      dp[amount] has our answer. If we do not have an answer then dp[amount]
      will be amount + 1 and hence dp[amount] > amount will be true. We then
      return -1.

      Otherwise, dp[amount] holds the answer
    */
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        MinimumCoinChange minimumCoinChange = new MinimumCoinChange();
        int res = minimumCoinChange.coinChangeTopDown(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864); // 24
        System.out.println(res);
    }

}
