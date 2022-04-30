package com.yyatsiuk.codingpatterns.sliding_window;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a>
 */
public class SellAndBuyStocks {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int windowStart = 0;
        for (int windowEnd = 1; windowEnd < prices.length; windowEnd++) {
            int profit = prices[windowEnd] - prices[windowStart];
            if (profit > 0) {
                maxProfit = Math.max(profit, maxProfit);
            } else {
                windowStart = windowEnd;
            }
        }

        return maxProfit;
    }

}
