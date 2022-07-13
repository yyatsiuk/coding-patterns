package com.yyatsiuk.codingpatterns.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/most-common-word/">819. Most Common Word</a>
 */
public class MostCommonWord {

    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


    public static void main(String[] args) {
        MostCommonWord test = new MostCommonWord();
        String s = test.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        System.out.println(s);
    }
}
