package com.yyatsiuk.codingpatterns.k_way_merge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>
 */
public class MergeKSortedLists {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));

        for (ListNode root : lists) {
            if (root != null) {
                minHeap.add(root);
            }
        }

        ListNode head = null;
        ListNode tail = null;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            if (head == null) {
                head = minNode;
                tail = minNode;
            } else {
                tail.next = minNode;
                tail = tail.next;
            }
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.mergeKLists(new ListNode[]{l1, l2, l3});
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}
