package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/">572. Subtree of Another Tree</a>
 */
public class SubtreeOfAnotherTree {

    /**
     * Time Complexity: Time worst-case complexity of above solution is O(mn) where m and n are number of nodes in given two trees.
     * Auxiliary space: O(n)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if ((root == null || subRoot == null) || (root.val != subRoot.val)) return false;

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

}
