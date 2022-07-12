package com.yyatsiuk.codingpatterns.data_structures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/max-stack/">716. Max Stack</a>
 */
public class MaxStack {

    private final TreeMap<Integer, Deque<ListNode>> treeMap;
    private final LinkedList dList;

    public MaxStack() {
        this.treeMap = new TreeMap<>();
        this.dList = new LinkedList();
    }

    public void push(int x) {
        ListNode node = dList.addFirst(x);

        if (!treeMap.containsKey(x)) {
            treeMap.put(x, new ArrayDeque<>());
        }

        treeMap.get(x).addFirst(node);
    }

    public int pop() {
        ListNode topItem = dList.removeFirst();
        treeMap.get(topItem.value).removeFirst();

        if (treeMap.get(topItem.value).isEmpty()) {
            treeMap.remove(topItem.value);
        }

        return topItem.value;
    }

    public int top() {
        return dList.peek();
    }

    public int peekMax() {
        return treeMap.lastKey();
    }

    public int popMax() {
        int maxElementValue = peekMax();
        Deque<ListNode> maxElements = treeMap.get(maxElementValue);
        ListNode maxNode = maxElements.pop();
        dList.removeNode(maxNode);

        if (maxElements.isEmpty()) {
            treeMap.remove(maxElementValue);
        }

        return maxElementValue;
    }

    private static class LinkedList {
        private final ListNode head;
        private final ListNode tail;

        public LinkedList() {
            this.head = new ListNode(null);
            this.tail = new ListNode(null);

            head.next = tail;
            tail.prev = head;
        }

        public ListNode addFirst(int value) {
            ListNode node = new ListNode(value);

            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;

            return node;
        }


        public ListNode removeFirst() {
            ListNode topNode = head.next;
            removeNode(topNode);

            return topNode;
        }

        private void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int peek() {
            return head.next.value;
        }
    }

    private static class ListNode {
        private final Integer value;
        private ListNode next;
        private ListNode prev;

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(4);
        maxStack.push(10);
        maxStack.push(3);
        maxStack.push(11);
        maxStack.push(2);
        maxStack.push(12);

        System.out.println(maxStack.popMax());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());
    }

}
