package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/">30. Substring with Concatenation of All Words</a>
 * <p>
 * Given a string and a pattern,
 * find the smallest substring in the given string which has all the character occurrences of the given pattern.
 * <p>
 * <b>Example 1:</b>
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * <p>
 * <b>Example 2:</b>
 * Input: String="aabdec", Pattern="abac"
 * Output: "aabdec"
 * Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"
 */
@Slf4j
public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0)
                    matched++;
            }

            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--;
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }


    public static void main(String[] args) {
        String substr = MinimumWindowSubstring.findSubstring("aabdec", "abc");
        System.out.println(substr);
    }

}
