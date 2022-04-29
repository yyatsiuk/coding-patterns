package com.yyatsiuk.codingpatterns.top_k;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an Array</a>
 */
public class KLargestNumbers {

    public int findKthLargestHeapSolution(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (heap.peek() < num) {
                heap.poll();
                heap.add(num);
            }
        }

        return heap.poll();
    }

}
