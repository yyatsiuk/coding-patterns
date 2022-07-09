package com.yyatsiuk.codingpatterns.sliding_window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">239. Sliding Window Maximum</a>
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[windowEnd]) {
                deque.removeLast();
            }
            deque.add(windowEnd);

            if (windowEnd >= k - 1) {
                result[windowStart] = nums[deque.peekFirst()];
                windowStart++;
            }

            if (windowStart > deque.peekFirst()) {
                deque.removeFirst();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5);
        System.out.println(Arrays.toString(ints));

    }
}
