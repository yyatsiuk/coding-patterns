package com.yyatsiuk.codingpatterns.prefix_sum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstSubarraySum {

    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        Map<Integer, Integer> prefSum = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            int compliment = sum - target;
            if (prefSum.containsKey(compliment)) {
                return List.of(prefSum.get(compliment) + 1, i + 1);
            }

            prefSum.put(sum, i);
        }

        return List.of();
    }

    public static void main(String[] args) {
        List<Integer> integerList = FirstSubarraySum.subarraySum(List.of(5, 0, 0, 2, -1, 1, 2, 4), 1);
        System.out.println(integerList);
    }
}
