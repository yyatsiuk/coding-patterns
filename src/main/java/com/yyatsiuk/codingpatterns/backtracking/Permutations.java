package com.yyatsiuk.codingpatterns.backtracking;

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
        permute(0, nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void permute(int index, int[] nums, List<Integer> perm, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i <= perm.size(); i++) {
                perm.add(i, nums[index]);
                permute(index + 1, nums, perm, result);
                perm.remove(i);
            }
        }
    }

    // the fastest solution from listed
    public static List<List<Integer>> findPermutationsRecursive2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute2(new boolean[nums.length], nums, new ArrayList<>(), result);
        return result;
    }

    private static void permute2(boolean[] visited, int[] nums, List<Integer> perm, List<List<Integer>> result) {
        if (perm.size() == visited.length) {
            result.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    perm.add(nums[i]);
                    visited[i] = true;

                    permute2(visited, nums, perm, result);

                    visited[i] = false;
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutationsRecursive2(new int[]{1, 2, 3});
        System.out.print("Here are all the permutations: " + result);
    }

}
