package com.yyatsiuk.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">78. Subsets</a>
 */
public class Subsets {

    /**
     * Time Complexity: O(2^N)
     * Space Complexity: O(2^N)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int index, int[] nums, List<Integer> set, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(set));
        } else {
            set.add(nums[index]);
            subsets(index + 1, nums, set, result);
            set.remove(set.size() - 1);
            subsets(index + 1, nums, set, result);
        }
    }

}
