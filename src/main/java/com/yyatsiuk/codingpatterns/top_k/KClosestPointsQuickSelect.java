package com.yyatsiuk.codingpatterns.top_k;

import java.util.Arrays;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">973. K Closest Points to Origin</a>
 */
public class KClosestPointsQuickSelect {

    private final Random random = new Random();

    public int[][] kClosest(int[][] points, int k) {
        if (points.length <= k) return points;

        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOf(points, k);
    }

    public void quickSelect(int[][] points, int lo, int hi, int k) {
        int pivot = random.nextInt(lo, hi + 1);
        int partition = partition(points, pivot, lo, hi);

        if (partition < k - 1) {
            quickSelect(points, partition + 1, hi, k);
        } else if (partition > k - 1) {
            quickSelect(points, lo, partition - 1, k);
        } else {
            return;
        }
    }

    private int partition(int[][] points, int pivotIndex, int lo, int hi) {
        swap(points, lo, pivotIndex);
        int[] pivot = points[lo];
        int pivotDistance = distanceToOrigin(pivot);
        int i = lo;

        for (int j = i + 1; j <= hi; j++) {
            if (distanceToOrigin(points[j]) < pivotDistance) {
                swap(points, ++i, j);
            }
        }

        swap(points, lo, i);
        return i;
    }

    private void swap(int[][] points, int index1, int index2) {
        int[] tmp = points[index1];
        points[index1] = points[index2];
        points[index2] = tmp;
    }

    private int distanceToOrigin(int[] coordinate) {
        return coordinate[0] * coordinate[0] + coordinate[1] * coordinate[1];
    }

    public static void main(String[] args) {
        KClosestPointsQuickSelect kClosestPoints = new KClosestPointsQuickSelect();
        int[][] ints = kClosestPoints.kClosest(new int[][]{
                {1, 1}, {2, 2}, {3, 3}, {5, 6}, {1, 0}, {0, 1}

        }, 3);

        System.out.println(Arrays.deepToString(ints));
    }

}
