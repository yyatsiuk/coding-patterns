package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The function should return an array containing any combination of elements
 * that add up to exactly the targetSum.
 */
public class HowSumToTarget {

    private final List<Integer> combination = new ArrayList<>();

    public List<Integer> howSum(int target, int[] nums) {
        Boolean[] memo = new Boolean[target + 1];
        if (howSum(target, memo, nums)) {
            return combination;
        } else {
            return List.of();
        }
    }

    private boolean howSum(int target, Boolean[] memo, int[] nums) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }

        if (memo[target] != null) {
            return memo[target];
        }

        for (int num : nums) {
            combination.add(num);
            memo[target] = howSum(target - num, memo, nums);
            if (Objects.equals(Boolean.TRUE, memo[target])) {
                return true;
            }
            combination.remove(combination.size() - 1);
        }

        memo[target] = false;
        return memo[target];
    }

    public List<Integer> howSum2(int target, int[] nums) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        return howSum2(target, memo, nums);
    }

    private List<Integer> howSum2(int target, Map<Integer, List<Integer>> memo, int[] nums) {
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        for (int num : nums) {
            List<Integer> comb = howSum2(target - num, memo, nums);
            if (comb != null) {
                comb.add(0, num);
                memo.put(target, comb);
                return comb;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        HowSumToTarget howSumToTarget = new HowSumToTarget();
        List<Integer> integers = howSumToTarget.howSum2(61, new int[]{5, 3, 4, 7});
        System.out.println(integers);
    }

}
