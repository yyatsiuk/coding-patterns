package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">438. Find All Anagrams in a String</a>
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <b>Example 1:</b>
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * <p>
 * <b>Example 2:</b>
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
@Slf4j
public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int windowStart = 0;
        Map<Character, Integer> letterFreqPattern = new HashMap<>();
        Map<Character, Integer> latterFreqWindow = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            letterFreqPattern.put(ch, letterFreqPattern.getOrDefault(ch, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char charRight = str.charAt(windowEnd);
            latterFreqWindow.put(charRight, latterFreqWindow.getOrDefault(charRight, 0) + 1);

            if (windowEnd - windowStart + 1 == pattern.length()) {
                if (latterFreqWindow.equals(letterFreqPattern)) {
                    resultIndices.add(windowStart);
                }

                char charLeft = str.charAt(windowStart);
                latterFreqWindow.put(charLeft, latterFreqWindow.get(charLeft) - 1);
                if (latterFreqWindow.get(charLeft) == 0) {
                    latterFreqWindow.remove(charLeft);
                }
                windowStart++;
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        log.info("Result = {}", StringAnagrams.findStringAnagrams("ppqp", "pq"));
        log.info("Result = {}", StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }

}
