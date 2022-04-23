package com.yyatsiuk.codingpatterns.top_k;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">973. K Closest Points to Origin</a>
 */
public class KClosestPointsToOrigins {

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((arr1, arr2) -> distance(arr2) - distance(arr1));

        for (int i = 0; i < k; i++) {
            maxHeap.add(points[i]);
        }

        for (int i = k; i < points.length; i++) {
            if (distance(points[i]) < distance(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }


        int[][] result = new int[maxHeap.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }

}
