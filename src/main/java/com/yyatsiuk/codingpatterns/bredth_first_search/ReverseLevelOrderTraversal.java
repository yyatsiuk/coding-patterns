package com.yyatsiuk.codingpatterns.bredth_first_search;

import com.yyatsiuk.codingpatterns.bredth_first_search.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">107. Binary Tree Level Order Traversal II</a>
 * <p>
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * <p>
 * <b>Example 1:</b>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * <p>
 * <b>Example 2:</b>
 * Input: root = [1]
 * Output: [[1]]
 */
public class ReverseLevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            List<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.remove();
                currentLevel.add(node.val);

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            result.add(0, currentLevel);
        }


        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }

}
