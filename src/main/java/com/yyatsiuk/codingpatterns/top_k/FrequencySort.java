package com.yyatsiuk.codingpatterns.top_k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sort-characters-by-frequency/">451. Sort Characters By Frequency</a>
 */
public class FrequencySort {

    public String frequencySort(String s) {

        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(counts.keySet());
        characters.sort((a, b) -> counts.get(b) - counts.get(a));

        // Convert the counts into a string with a sb.
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            sb.append(String.valueOf(c).repeat(Math.max(0, counts.get(c))));
        }
        return sb.toString();
    }

    public String frequencySortOptimized(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int maxFreq = Collections.max(counts.values());
        List<Character>[] buckets = new List[maxFreq + 1];
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        StringBuilder strBuilder = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (Character ch : buckets[i]) {
                    strBuilder.append(String.valueOf(ch).repeat(i));
                }
            }
        }

        return strBuilder.toString();
    }


    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        String result = frequencySort.frequencySortOptimized("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = frequencySort.frequencySortOptimized("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }

}
