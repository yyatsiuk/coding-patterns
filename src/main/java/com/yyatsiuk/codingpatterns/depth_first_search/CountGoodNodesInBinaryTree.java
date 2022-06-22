package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/submissions/">1448. Count Good Nodes in Binary Tree</a>
 */
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        if (root.val >= max) {
            return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
        }

        return dfs(root.left, max) + dfs(root.right, max);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(5);

        CountGoodNodesInBinaryTree binaryTree = new CountGoodNodesInBinaryTree();
        int result = binaryTree.goodNodes(treeNode);
        System.out.println(result);
    }

}
