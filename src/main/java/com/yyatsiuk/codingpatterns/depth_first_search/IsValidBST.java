package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="98. Validate Binary Search Tree">https://leetcode.com/problems/validate-binary-search-tree/</a>
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // In Order Traversal Solution
    private Integer prev;
    private boolean inOrder(TreeNode root) {
        if (root == null) return true;

        if (!inOrder(root.left)) return false;
        if (prev != null && prev >= root.val) return false;
        prev = root.val;
        return inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(2);
        tree.left.left.right = new TreeNode(4);
        tree.right = new TreeNode(9);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(10);

        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(tree));
    }
}
