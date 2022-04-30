package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">230. Kth Smallest Element in a BST</a>
 */
public class KthSmallestValInBST {

    int count = 0;
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverseInOrder(root, k);
        return val;
    }

    private void traverseInOrder(TreeNode root, int k) {
        if (root == null) return;

        traverseInOrder(root.left, k);
        if (++count == k) val = root.val;
        traverseInOrder(root.right, k);
    }

}
