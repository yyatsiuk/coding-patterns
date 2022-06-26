package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/decode-ways/">91. Decode Ways</a>
 */
public class DecodeWays {

    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return numDecodings(s, 0, memo);
    }

    private int numDecodings(String s, int index, Integer[] memo) {
        if (index < memo.length && memo[index] != null) {
            return memo[index];
        }

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (index == s.length() - 1) {
            return 1;
        }

        int res = numDecodings(s, index + 1, memo);
        if (((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0')) <= 26) {
            res += numDecodings(s, index + 2, memo);
        }

        memo[index] = res;
        return memo[index];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println("decodeWays.numDecodings(\"124421\") = " + decodeWays.numDecodings("124421"));
    }

}
