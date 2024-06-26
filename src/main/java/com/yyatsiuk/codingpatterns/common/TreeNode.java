package com.yyatsiuk.codingpatterns.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = x;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.remove();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            System.out.println();
        }
    }

}
