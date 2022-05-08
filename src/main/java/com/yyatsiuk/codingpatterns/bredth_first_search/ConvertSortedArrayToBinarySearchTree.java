package com.yyatsiuk.codingpatterns.bredth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">108. Convert Sorted Array to Binary Search Tree</a>
 */
public class ConvertSortedArrayToBinarySearchTree {

    private int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1);
        root.right = helper(mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

}
