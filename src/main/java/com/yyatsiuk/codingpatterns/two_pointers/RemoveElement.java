package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.com/problems/remove-element/submissions/">27. Remove Element</a>
 * <p>
 * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
 * <p>
 * <b>Example 1:</b>
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 * <p>
 * <b>Example 2:</b>
 * Input: [2, 11, 2, 2, 1], Key=2
 * Output: 2
 * Explanation: The first two elements after removing every 'Key' will be [11, 1].
 */
@Slf4j
public class RemoveElement {

    public static int remove(int[] arr, int key) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[j] = arr[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        log.info("Result = {}", RemoveElement.remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3));
        log.info("Result = {}", RemoveElement.remove(new int[]{2, 11, 2, 2, 1}, 2));
    }

}
