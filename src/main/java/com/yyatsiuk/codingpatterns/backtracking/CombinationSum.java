package com.yyatsiuk.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), results);
        return results;
    }


    private void backtrack(int index, int[] candidates, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        if (target - candidates[index] >= 0) {
            comb.add(candidates[index]);
            backtrack(index, candidates, target - candidates[index], comb, result);
            comb.remove(comb.size() - 1);
        }

        backtrack(index + 1, candidates, target, comb, result);
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(new int[]{2, 1, 1}, 4);
        System.out.println(result);
    }


}
