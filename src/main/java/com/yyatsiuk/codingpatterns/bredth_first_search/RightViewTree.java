package com.yyatsiuk.codingpatterns.bredth_first_search;

import com.yyatsiuk.codingpatterns.bredth_first_search.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">199. Binary Tree Right Side View</a>
 * <p>
 * Given the root of a binary tree,
 * imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * <b>Example 1:</b>
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * <b>Example 2:</b>
 * Input: root = [1,null,3]
 * Output: [1,3]
 */
public class RightViewTree {

    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        TreeNode node = null;
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            for (int i = 0; i < levelSize; i++) {
                node = nodes.remove();

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            result.add(node);
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
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
