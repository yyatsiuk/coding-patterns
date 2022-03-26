package com.yyatsiuk.codingpatterns.cyclic_sort;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY">Cyclic Sort</a>
 * <p>
 * We are given an array containing n objects. Each object,
 * when created, was assigned a unique number from the range 1 to n based on their creation sequence.
 * This means that the object with sequence number 3 was created just before the object with sequence number 4.
 * Write a function to sort the objects in-place on their creation sequence number in O(n)
 * and without using any extra space. For simplicity,let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.
 * <p>
 * <b>Example 1:</b>
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 * <p>
 * <b>Example 2:</b>
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 */
public class CyclicSort {

    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int expectedIndex = nums[i] - 1;
            if (expectedIndex != i) {
                swap(nums, i, expectedIndex);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 6, 4, 3, 1, 5};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{1, 5, 6, 4, 3, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

}
