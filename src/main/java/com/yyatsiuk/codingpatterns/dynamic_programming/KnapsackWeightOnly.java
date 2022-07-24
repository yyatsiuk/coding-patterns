package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://algo.monster/problems/knapsack_weight_only">Knapsack, Weight-Only</a>
 */
public class KnapsackWeightOnly {

    public static List<Integer> knapsackWeightOnly(List<Integer> weights) {
        int sum = weights.stream().mapToInt(Integer::intValue).sum();
        boolean[][] memo = new boolean[weights.size()][sum + 1];
        Set<Integer> sums = new HashSet<>();
        generateSums(0, weights, sums, 0, memo);
        return new ArrayList<>(sums);
    }

    public static void generateSums(int index, List<Integer> weights, Set<Integer> sums, int sum, boolean[][] memo) {
        if (index == weights.size()) {
            sums.add(sum);
            return;
        }
        if (memo[index][sum]) return;

        memo[index][sum] = true;
        generateSums(index + 1, weights, sums, sum, memo);
        generateSums(index + 1, weights, sums, sum + weights.get(index), memo);
    }

    public static void main(String[] args) {
        List<Integer> integers = knapsackWeightOnly(List.of(49, 73, 58, 30, 72, 44, 78));
        Collections.sort(integers);
        System.out.println(integers);
    }

}
