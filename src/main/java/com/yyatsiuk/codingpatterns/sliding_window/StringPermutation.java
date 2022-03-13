package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">567. Permutation in String</a>
 * <p>
 * <b>Given a string and a pattern, find out if the string contains any permutation of the pattern.</b>
 * <p>
 * <b>Example 1:</b>
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * <p>
 * <b>Example 2:</b>
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * <p>
 * <b>Example 3:</b>
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * <p>
 * <b>Example 4:</b>
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
@Slf4j
public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0;
        int k = pattern.length();
        Map<Character, Integer> letterFreqMapWindow = new HashMap<>();
        Map<Character, Integer> letterFreqMapPattern = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            letterFreqMapPattern.put(ch, letterFreqMapPattern.getOrDefault(ch, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char charRight = str.charAt(windowEnd);
            letterFreqMapWindow.put(charRight, letterFreqMapWindow.getOrDefault(charRight, 0) + 1);

            if (windowEnd - windowStart + 1 == k) {
                if (letterFreqMapWindow.equals(letterFreqMapPattern)) {
                    return true;
                }

                char charLeft = str.charAt(windowStart);
                letterFreqMapWindow.put(charLeft, letterFreqMapWindow.get(charLeft) - 1);
                if (letterFreqMapWindow.get(charLeft) == 0) {
                    letterFreqMapWindow.remove(charLeft);
                }
                windowStart++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        log.info("Result = {}", StringPermutation.findPermutation("oidbcaf", "abc"));
        log.info("Result = {}", StringPermutation.findPermutation("odicf", "dc"));
        log.info("Result = {}", StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        log.info("Result = {}", StringPermutation.findPermutation("aaacb", "abc"));
    }
}
