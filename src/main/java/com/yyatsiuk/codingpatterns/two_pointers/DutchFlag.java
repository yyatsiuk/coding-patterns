package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">75. Sort Colors</a>
 * <p>
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * <b>Example 2:</b>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
@Slf4j
public class DutchFlag {

    public static void sort(int[] arr) {
        int x = 0;
        int y = 0;

        for (int number : arr) {
            if (number == 0) x++;
            else if (number == 1) y++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < x) {
                arr[i] = 0;
            } else if (i < x + y) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 1, 1, 0, 0, 0, 2, 2, 1, 1, 1, 0};
        sort(arr);
        log.info("Result = {}", Arrays.toString(arr));
    }

}
