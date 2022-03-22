package com.yyatsiuk.codingpatterns.fast_and_slow_pointers;

public class LinkedListCycleLength {

    private static class ListNode {
        private int value;
        private ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static int findCycleLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int cycleLength = 1;
                ListNode current = fast.next;
                while (current != slow) {
                    cycleLength++;
                    current = current.next;
                }

                return cycleLength;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

    }

}
