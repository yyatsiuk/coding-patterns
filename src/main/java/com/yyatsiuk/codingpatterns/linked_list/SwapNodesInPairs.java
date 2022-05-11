package com.yyatsiuk.codingpatterns.recursion;

import com.yyatsiuk.codingpatterns.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">24. Swap Nodes in Pairs</a>
 */
@SuppressWarnings("Duplicates")
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head.next;
        ListNode next = curr.next;

        curr.next = head;
        head.next = next;

        curr.next.next = swapPairs(curr.next.next);

        return curr;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        swapNodesInPairs.swapPairs(listNode).print();
    }

}
