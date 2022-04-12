package com.yyatsiuk.codingpatterns.two_heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-median-from-data-stream/">295. Find Median from Data Stream</a>
 */
public class MedianFinder {

    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            int maxHeapTop = maxHeap.isEmpty() ? 0 : maxHeap.peek();
            int minHeapTop = minHeap.isEmpty() ? 0 : minHeap.peek();
            return (maxHeapTop + minHeapTop) * 0.5;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianOfAStream = new MedianFinder();
        medianOfAStream.addNum(3);
        medianOfAStream.addNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.addNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.addNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }

}
