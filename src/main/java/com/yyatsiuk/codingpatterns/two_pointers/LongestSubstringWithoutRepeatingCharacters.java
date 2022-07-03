package com.yyatsiuk.codingpatterns.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        Map<Character, Integer> letters = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);
            if (letters.containsKey(ch)) {
                windowStart = Math.max(windowStart, letters.get(ch) + 1);
            }

            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
            letters.put(ch, windowEnd);
        }

        return maxLength;
    }

}
