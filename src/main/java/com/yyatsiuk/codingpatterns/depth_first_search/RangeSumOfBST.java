package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-bst/">938. Range Sum of BST</a>
 */
public class RangeSumOfBST {

    /**
     * Time Complexity: O(N), where NN is the number of nodes in the tree.
     * Space Complexity: O(N)
     */
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        range(root, low, high);
        return sum;
    }

    private void range(TreeNode root, int low, int high) {
        if (root == null) return;

        if (root.val >= low && root.val <= high) sum += root.val;
        if (root.val >= low) range(root.left, low, high);
        if (root.val <= high) range(root.right, low, high);
    }


}
