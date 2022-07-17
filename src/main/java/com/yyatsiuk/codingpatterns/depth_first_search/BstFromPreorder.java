package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">1008. Construct Binary Search Tree from Preorder Traversal</a>
 */
public class BstFromPreorder {

    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, bound);
        return root;
    }

    public TreeNode bstFromPreorderMonotonicStack(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        for (int i = 1; i < n; i++) {
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);
            while (!deque.isEmpty() && deque.peek().val < child.val)
                node = deque.pop();

            if (node.val < child.val) node.right = child;
            else node.left = child;
            deque.push(child);
        }

        return root;
    }

}
