package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/gxrnL0GQGqk">Subset Sum (medium)</a>
 */
public class SubsetWithTargetSum {

    static boolean canPartition(int[] nums, int sum) {
        if (nums == null || nums.length <= 1) return false;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentNum = nums[i];
            Set<Integer> nextSet = new HashSet<>();
            for (Integer subsetSum : set) {
                nextSet.add(subsetSum);
                nextSet.add(subsetSum + currentNum);
                if (nextSet.contains(sum)) return true;
            }
            set = nextSet;
        }

        return false;
    }

}
