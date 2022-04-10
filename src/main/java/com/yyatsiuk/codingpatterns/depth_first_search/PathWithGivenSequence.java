package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/">1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree</a>
 * <p>
 * Given a binary tree where each path going from the root to any leaf form a valid sequence,
 * check if a given string is a valid sequence in such binary tree.
 * We get the given string from the concatenation of an array of integers arr
 * and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 * <p>
 * <b>Example 1:</b>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 */
public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null) {
            return false;
        }
        return helper(root, sequence, 0);
    }

    private static boolean helper(TreeNode root, int[] sequence, int level) {
        if (root == null) {
            return false;
        }

        if (level >= sequence.length || root.val != sequence[level]) {
            return false;
        }

        if (sequence[level] == root.val && root.left == null && root.right == null) {
            return true;
        }

        return helper(root.left, sequence, level + 1) || helper(root.right, sequence, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 0, 7}));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 6}));
    }

}
