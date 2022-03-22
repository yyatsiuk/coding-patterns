package com.yyatsiuk.codingpatterns.fast_and_slow_pointers;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">234. Palindrome Linked List</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * <a>Example 1:</a>
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * <b>Example 2:</b>
 * Input: head = [1,2]
 * Output: false
 */
public class PalindromicLinkedList {

    private static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow);
        ListNode copyHeadSecondHalf = headSecondHalf;
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                isPalindrome = false;
                break;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf);
        return isPalindrome;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }

}
