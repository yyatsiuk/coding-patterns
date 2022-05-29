package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">516. Longest Palindromic Subsequence</a>
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubstring(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return longestPalindromeSubseq(s, 0, s.length() - 1, memo);
    }

    private int longestPalindromeSubseq(String s, int lo, int hi, Integer[][] memo) {
        if (lo > hi) return 0;
        if (lo == hi) return 1;

        if (memo[lo][hi] == null) {
            if (s.charAt(lo) == s.charAt(hi)) {
                memo[lo][hi] = 2 + longestPalindromeSubseq(s, lo + 1, hi - 1, memo);
            } else {
                memo[lo][hi] = Math.max(longestPalindromeSubseq(s, lo + 1, hi, memo), longestPalindromeSubseq(s, lo, hi - 1, memo));
            }
            return memo[lo][hi];
        }

        return memo[lo][hi];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.longestPalindromeSubstring("abdbca"));
    }

}
