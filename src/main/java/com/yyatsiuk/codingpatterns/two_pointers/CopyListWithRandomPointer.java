package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">138. Copy List with Random Pointer</a>
 */
public class CopyListWithRandomPointer {

    @NoArgsConstructor
    private static class Node {
        private int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    private final Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(head.val);
        visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = copyNode(oldNode.random);
            newNode.next = copyNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visited.get(head);
    }

    private Node copyNode(Node node) {
        if (node != null) {
            if (visited.containsKey(node)) return visited.get(node);
            else {
                Node newNode = new Node(node.val);
                visited.put(node, newNode);
                return newNode;
            }
        }

        return null;
    }

}
