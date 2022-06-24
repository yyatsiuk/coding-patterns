package com.yyatsiuk.codingpatterns.backtracking;

import com.yyatsiuk.codingpatterns.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-paths/">257. Binary Tree Paths</a>
 */
public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, List<String> path, List<String> allPaths) {
        if (root.left == null && root.right == null) {
            path.add(String.valueOf(root.val));
            allPaths.add(String.join("->", path));
            return;
        }

        path.add(String.valueOf(root.val));

        if (root.left != null) {
            binaryTreePaths(root.left, path, allPaths);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, path, allPaths);
            path.remove(path.size() - 1);
        }
    }

}
