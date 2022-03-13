package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
@Slf4j
public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        int windowStart = 0;
        int maxSubstrSize = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxSubstrSize = Math.max(maxSubstrSize, windowEnd - windowStart + 1);
        }

        return maxSubstrSize;
    }

    public static void main(String[] args) {
        int result = findLength("cbbebi", 3);
        System.out.println(result);
    }

}
