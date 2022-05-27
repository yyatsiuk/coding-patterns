package com.yyatsiuk.codingpatterns.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/time-based-key-value-store/">981. Time Based Key-Value Store</a>
 */
public class TimeMap {

    private record ComposedKey(String key, int timestamp) {
    }

    private final Map<ComposedKey, String> hashtable;
    private final Map<String, List<Integer>> timestamps;

    public TimeMap() {
        this.hashtable = new HashMap<>();
        this.timestamps = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hashtable.put(new ComposedKey(key, timestamp), value);
        List<Integer> stmps = timestamps.getOrDefault(key, new ArrayList<>());
        stmps.add(timestamp);
        timestamps.put(key, stmps);
    }

    public String get(String key, int timestamp) {
        String v = hashtable.get(new ComposedKey(key, timestamp));
        if (v != null) return v;
        else if (!timestamps.containsKey(key) || timestamp < timestamps.get(key).get(0)) return "";
        else return hashtable.get(new ComposedKey(key, findNum(timestamps.get(key), timestamp)));
    }

    private int findNum(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            Integer midValue = list.get(mid);
            if (target < midValue) {
                hi = mid - 1;
            } else if (target > midValue) {
                lo = mid + 1;
            } else {
                return midValue;
            }
        }

        return lo > 0 ? list.get(lo - 1) : list.get(lo);
    }

}
