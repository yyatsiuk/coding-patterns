package com.yyatsiuk.codingpatterns.top_k;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/ugly-number-ii/">264. Ugly Number II</a>
 */
public class UglyNumberNth {

    public static int printUglyNumbers(int n) {
        Queue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> usedNums = new HashSet<>();
        int[] allowedPrime = {2, 3, 5};
        minHeap.offer(1L);
        usedNums.add(1L);
        for (int i = 1; i < n; i++) {
            long res = minHeap.poll();
            for (int multiplier : allowedPrime) {
                long num = res * multiplier;
                if (!usedNums.contains(num)) {
                    minHeap.offer(num);
                    usedNums.add(num);
                }
            }
        }

        return minHeap.poll().intValue();
    }

    public static void main(String[] args) {
        int i = printUglyNumbers(10);
        System.out.println(i);

    }

}
