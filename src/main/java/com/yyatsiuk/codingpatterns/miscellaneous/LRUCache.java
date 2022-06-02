package com.yyatsiuk.codingpatterns.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/submissions/">146. LRU Cache</a>
 */
public class LRUCache {

    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;

        list.moveUp(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            list.remove(oldNode);
        } else if (cache.size() == capacity) {
            Node oldNode = list.removeLast();
            cache.remove(oldNode.key);
        }

        list.addFirst(node);
        cache.put(key, node);
    }

    private static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;

        }
    }

    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        public DoublyLinkedList() {
            this.head = new Node();
            this.tail = new Node();

            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public Node removeLast() {
            Node tailNode = tail.prev;
            remove(tailNode);

            return tailNode;
        }

        public void moveUp(Node node) {
            remove(node);
            addFirst(node);
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}
