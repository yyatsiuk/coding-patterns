package com.yyatsiuk.codingpatterns.reversal_of_linked_list;

/**
 * <a href="https://leetcode.com/problems/rotate-list/">61. Rotate List</a>
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * <b>Example 1:</b>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * <p>
 * <b>Example 2:</b>
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode rotateRight(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0)
            return head;

        // find the length and the last node of the list
        ListNode lastNode = head;
        int listLength = 1;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            listLength++;
        }

        lastNode.next = head; // connect the last node with the head to make it a circular list
        rotations %= listLength; // no need to do rotations more than the length of the list
        int skipLength = listLength - rotations;
        ListNode lastNodeOfRotatedList = head;
        for (int i = 0; i < skipLength - 1; i++)
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;

        // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = RotateList.rotateRight(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
