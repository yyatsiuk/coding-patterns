package com.yyatsiuk.codingpatterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/permutations/">46. Permutations</a>
 */
public class Permutations {

    /**
     * Time Complexity: O(N ∗ N!)
     * Space Complexity: O(N * N!)
     */
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for (int num : nums) {
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, num);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }

        return result;
    }

    /**
     * Time Complexity: O(N ∗ N!)
     * Space Complexity: O(N * N!)
     */
    public static List<List<Integer>> findPermutationsRecursive(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutationsRecursive(0, nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void findPermutationsRecursive(int index, int[] nums, List<Integer> perms, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(perms);
            return;
        }

        for (int i = 0; i <= perms.size(); i++) {
            ArrayList<Integer> newPerms = new ArrayList<>(perms);
            newPerms.add(i, nums[index]);
            findPermutationsRecursive(index + 1, nums, newPerms, result);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutationsRecursive(new int[]{1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }

}
