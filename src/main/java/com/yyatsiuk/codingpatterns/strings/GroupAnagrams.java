package com.yyatsiuk.codingpatterns.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagramsWithSort(String[] strings) {
        if (strings.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            ans.putIfAbsent(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    public List<List<String>> groupAnagrams(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);

            map.putIfAbsent(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }


}
