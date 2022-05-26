package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">236. Lowest Common Ancestor of a Binary Tree</a>
 */
public class LCAOfSearchTree {

    /**
     * Time Complexity : O(N), where N is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.
     * Space Complexity : O(N). In the worst case space utilized by the stack, the parent pointer dictionary and the ancestor set, would be N each, since the height of a skewed binary tree could be N.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(10);
        treeNode.right.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(8);

        LCAOfSearchTree lcaOfSearchTree = new LCAOfSearchTree();
        TreeNode lca = lcaOfSearchTree.lowestCommonAncestor(treeNode, new TreeNode(10), new TreeNode(4));
        System.out.println(lca);
    }
}
