package com.yyatsiuk.codingpatterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>
 */
public class Combinations {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(0, candidates, target, comb, results);
        return results;
    }

    private void backtrack(int i, int[] candidates, int target, List<Integer> comb, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(comb));
            return;
        }
        if (target < 0 || i >= candidates.length) return;

        if (candidates[i] <= target) {
            comb.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i], comb, results);
            comb.remove(comb.size() - 1);
        }
        backtrack(i + 1, candidates, target, comb, results);
    }


    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> combinationSum = combinations.combinationSum(new int[]{2, 3}, 6);
        System.out.println(combinationSum);
    }
}
