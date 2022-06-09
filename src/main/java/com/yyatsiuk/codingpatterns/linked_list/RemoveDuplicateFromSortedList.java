package com.yyatsiuk.codingpatterns.linked_list;

import com.yyatsiuk.codingpatterns.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">83. Remove Duplicates from Sorted List</a>
 */
public class RemoveDuplicateFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);

        RemoveDuplicateFromSortedList removeDuplicateFromSortedList = new RemoveDuplicateFromSortedList();
        ListNode list = removeDuplicateFromSortedList.deleteDuplicates(listNode);
        list.print();
    }

}
