package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree/">701. Insert into a Binary Search Tree</a>
 */
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return root;
                } else curr = curr.left;

            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                } else curr = curr.right;
            }
        }

        return new TreeNode(val);
    }

}
