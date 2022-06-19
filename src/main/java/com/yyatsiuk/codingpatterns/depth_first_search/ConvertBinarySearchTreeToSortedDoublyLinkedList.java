package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.Node;

/**
 * <a href="https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">426. Convert Binary Search Tree to Sorted Doubly Linked List</a>
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    private Node head = null;
    private Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inOrder(root);
        prev.right = head;
        head.left = prev;

        return head;

    }

    private void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);

        if (head == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;

        inOrder(root.right);
    }

}
