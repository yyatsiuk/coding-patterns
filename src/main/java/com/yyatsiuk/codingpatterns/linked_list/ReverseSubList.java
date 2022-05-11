package com.yyatsiuk.codingpatterns.reversal_of_linked_list;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Reverse Linked List II</a>
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * <b>Example 1:</b>
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * <p>
 * <b>Example 2:</b>
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 */
public class ReverseSubList {

    static class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        for (int i = 1; curr != null && i < p - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode lastNodeOfFirstPart = prev;
        ListNode lastNodeOfSubList = curr;
        for (int i = 0; curr != null && i < q - p + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = prev;
        } else {
            head = prev;
        }

        lastNodeOfSubList.next = curr;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
