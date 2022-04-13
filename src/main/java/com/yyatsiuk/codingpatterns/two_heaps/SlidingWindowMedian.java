package com.yyatsiuk.codingpatterns.two_heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/sliding-window-median">480. Sliding Window Median</a>
 */
public class SlidingWindowMedian {

    private final Queue<Integer> minHeap = new PriorityQueue<>();
    private final Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            rebalanceHeaps();

            int elemInWindow = i - k + 1;
            if (elemInWindow >= 0) {
                if (k % 2 == 0) {
                    int maxHeapTop = maxHeap.isEmpty() ? 0 : maxHeap.peek();
                    int minHeapTop = minHeap.isEmpty() ? 0 : minHeap.peek();
                    result[elemInWindow] = maxHeapTop / 2.0 + minHeapTop / 2.0;
                } else {
                    result[elemInWindow] = maxHeap.peek();
                }

                int elementToBeRemoved = nums[elemInWindow];
                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                rebalanceHeaps();
            }
        }

        return result;
    }

    private void rebalanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.medianSlidingWindow(new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.medianSlidingWindow(new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
