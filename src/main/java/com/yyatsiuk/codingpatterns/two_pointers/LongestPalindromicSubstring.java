package com.yyatsiuk.codingpatterns.two_pointers;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
 */
public class LongestPalindromicSubstring {

    private int n;
    private int start;
    private int end;
    private int maxLen;

    public String longestPalindrome(String s) {
        this.n = s.length();
        this.start = 0;
        this.end = 0;
        this.maxLen = 0;

        for (int position = 0; position < n; position++) {
            expandAroundTheCenter(s, position, position);
            expandAroundTheCenter(s, position, position + 1);
        }

        return s.substring(start, end + 1);
    }

    private void expandAroundTheCenter(String s, int left, int right) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            int windowSize = right - left + 1;
            if (windowSize > maxLen) {
                start = left;
                end = right;
                maxLen = windowSize;
            }
            left--;
            right++;
        }
    }

}
