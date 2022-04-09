package com.yyatsiuk.codingpatterns.bredth_first_search;

import com.yyatsiuk.codingpatterns.bredth_first_search.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/NE5109Jl02v">Connect All Level Order Siblings</a>
 * <p>
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to the first node of the next level.
 */
@SuppressWarnings("Duplicates")
public class ConnectAllSiblings {

    public static void connect(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        Node prevNode = null;
        while (!nodes.isEmpty()) {
            Node currNode = nodes.remove();
            if (prevNode != null) {
                prevNode.next = currNode;
            }
            prevNode = currNode;
            if (currNode.left != null) {
                nodes.add(currNode.left);
            }
            if (currNode.right != null) {
                nodes.add(currNode.right);
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
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        Node current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}
