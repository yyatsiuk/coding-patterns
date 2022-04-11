package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii/">437. Path Sum III</a>
 * <p>
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * <p>
 * <b>Example 1:</b>
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * <p>
 * <b>Example 2:</b>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 */
public class CountAllPathSum {

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return helper(root, new ArrayList<>(), targetSum);
    }

    private static int helper(TreeNode root, List<Integer> currentPath, int targetSum) {
        if (root == null) {
            return 0;
        }

        currentPath.add(root.val);
        int sum = 0;
        int count = 0;
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            sum += pathIterator.previous();
            if (sum == targetSum) {
                count++;
            }
        }

        count += helper(root.left, currentPath, targetSum);
        count += helper(root.right, currentPath, targetSum);

        currentPath.remove(currentPath.size() - 1);

        return count;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("Tree has path: " + pathSum(root, 12));
    }

}
