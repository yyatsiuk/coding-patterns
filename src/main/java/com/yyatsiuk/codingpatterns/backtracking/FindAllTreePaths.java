package com.yyatsiuk.codingpatterns.backtracking;

import com.yyatsiuk.codingpatterns.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="113. Path Sum II">https://leetcode.com/problems/path-sum-ii/</a>
 * <p>
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * <p>
 * <b>Example 1:</b>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 */
public class FindAllTreePaths {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private static void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            dfs(root.left, sum - root.val, path, paths);
            dfs(root.right, sum - root.val, path, paths);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

}
