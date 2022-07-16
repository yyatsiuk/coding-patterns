package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/count-number-of-teams/">1395. Count Number of Teams</a>
 */
public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int[] inc = new int[rating.length];
        int[] dec = new int[rating.length];
        int ans = 0;

        for (int i = 0; i < rating.length; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    inc[i]++;
                    ans += inc[j];
                } else {
                    dec[i]++;
                    ans += dec[j];
                }
            }
        }

        return ans;
    }

}
