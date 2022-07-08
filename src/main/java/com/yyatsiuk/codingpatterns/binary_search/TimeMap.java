package com.yyatsiuk.codingpatterns.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/time-based-key-value-store/">981. Time Based Key-Value Store</a>
 */
public class TimeMap {

    private record TimeValue(String value, int time) {
    }

    private final Map<String, List<TimeValue>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new TimeValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeValue> timeValue = store.get(key);
        if (timeValue == null || timeValue.isEmpty()) {
            return "";
        }

        int time = binarySearch(timeValue, timestamp);
        if (time == -1) return "";
        return timeValue.get(time).value;
    }

    private int binarySearch(List<TimeValue> values, int timestamp) {
        int left = 0;
        int right = values.size() - 1;
        int boundaryIndex = -1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (values.get(mid).time == timestamp) return mid;
            else if (values.get(mid).time > timestamp) {
                right = mid - 1;
            } else {
                boundaryIndex = mid;
                left = mid + 1;
            }
        }

        return boundaryIndex;
    }

}
