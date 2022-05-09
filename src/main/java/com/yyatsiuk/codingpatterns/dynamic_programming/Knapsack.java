package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/gkZNLjV2kBk">0/1 Knapsack</a>
 */
public class Knapsack {

    public int solveKnapsackBottomUpOptimal(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2;

                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }

                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n - 1][capacity];
    }

    public int solveKnapsackBrute(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursiveBrute(profits, weights, capacity, 0);
    }

    private int knapsackRecursiveBrute(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapsackRecursiveBrute(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursiveBrute(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsackBrute(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackBottomUpOptimal(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

}
