package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with Distinct Characters (hard)
 * <p>
 * Example 1:
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring with distinct characters is "abc".
 * <p>
 * Example 2:
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings with distinct characters are "abc" & "cde".
 * <p>
 * Example 3:
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings with distinct characters are "abc" & "cde".
 */
@Slf4j
public class NoRepeatSubstring {


    public static int findLength(String s) {
        int maxLength = 0;
        int windowStart = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }

            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        log.info("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        log.info("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        log.info("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }

}
