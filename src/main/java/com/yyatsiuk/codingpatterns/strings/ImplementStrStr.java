package com.yyatsiuk.codingpatterns.strings;

/**
 * <a href="https://leetcode.com/problems/implement-strstr/">28. Implement strStr()</a>
 */
public class ImplementStrStr {

    public int strStrBrute(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == m) return i;
        }

        return -1;
    }


    public int strStrKMP(String text, String pattern) {
        int i = 0;
        int j = 0;
        int[] lpsa = computeLPSA(pattern);
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lpsa[j - 1];
                }
            }

            if (j == pattern.length()) return i - pattern.length();
        }

        return -1;
    }

    private int[] computeLPSA(String pattern) {
        int[] lps = new int[pattern.length()];
        int prevLPS = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(prevLPS) == pattern.charAt(i)) {
                lps[i++] = ++prevLPS;
            } else if (prevLPS == 0) {
                lps[i++] = 0;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        ImplementStrStr test = new ImplementStrStr();
        int res = test.strStrBrute("hello", "ll");
        System.out.println(res);
    }
}
