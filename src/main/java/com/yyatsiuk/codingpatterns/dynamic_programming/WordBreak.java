package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/word-break/">139. Word Break</a>
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return wordBreak(0, memo, s, wordDict);
    }

    private boolean wordBreak(int startIndex, Boolean[] memo, String s, List<String> wordDict) {
        if (startIndex == s.length()) {
            return true;
        }

        if (memo[startIndex] != null) return memo[startIndex];

        for (String word : wordDict) {
            if (s.startsWith(word, startIndex)) {
                boolean res = wordBreak(startIndex + word.length(), memo, s, wordDict);
                memo[startIndex] = res;
                if (res) return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        WordBreak object = new WordBreak();
        boolean res = object.wordBreak("leetcode", List.of("leet", "code"));
        System.out.println(res);
    }

}
