package com.yyatsiuk.codingpatterns.top_k;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">703. Kth Largest Element in a Stream</a>
 */
public class KthLargest {

    private final int k;
    private final Queue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this. minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
