package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/delete-and-earn/">740. Delete and Earn</a>
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + num);
        }

        List<Integer> numbers = new ArrayList<>(counts.keySet());
        Collections.sort(numbers);

        int twoBack = 0;
        int oneBack = counts.get(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            int tmp = 0;
            if (numbers.get(i) == numbers.get(i - 1) + 1) {
                tmp = Math.max(twoBack + counts.get(numbers.get(i)), oneBack);
            } else {
                tmp = oneBack + counts.get(numbers.get(i));
            }
            twoBack = oneBack;
            oneBack = tmp;
        }

        return oneBack;

    }

}
