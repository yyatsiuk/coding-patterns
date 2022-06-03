package com.yyatsiuk.codingpatterns.math;

import java.util.Arrays;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/shuffle-an-array/">384. Shuffle an Array</a>
 */
public class ShuffleAnArray {

    private final int[] original;
    private final int[] copy;
    private final Random random;

    public ShuffleAnArray(int[] nums) {
        this.original = nums;
        this.copy = Arrays.copyOf(nums, nums.length);
        this.random = new Random();
    }

    public int[] reset() {
        return this.original;
    }

    public int[] shuffle() {
        for (int i = copy.length - 1; i >= 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            swap(copy, randomIndex, i);
        }

        return copy;
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
