package com.yyatsiuk.codingpatterns.bredth_first_search;

import com.yyatsiuk.codingpatterns.bredth_first_search.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">116. Populating Next Right Pointers in Each Node</a>
 * <p>
 * Given a binary tree, connect each node with its level order successor. The last node of each level should point to a null node.
 * <p>
 * <b>Example 1:</b>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
class ConnectLevelOrderSiblings {

    public static void connect(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            Node prev = null;
            for (int i = 0; i < levelSize; i++) {
                Node node = nodes.remove();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

}