package com.yyatsiuk.codingpatterns.top_k;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-connect-sticks/">1167. Minimum Cost to Connect Sticks</a>
 */
public class ConnectSticks {

    public int connectSticks(int[] sticks) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : sticks) {
            minHeap.add(num);
        }

        int sum = 0;
        while (minHeap.size() > 1) {
            int cost = minHeap.poll() + minHeap.poll();
            sum += cost;
            minHeap.add(cost);
        }
        return sum;
    }

}
