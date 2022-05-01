package com.yyatsiuk.codingpatterns.k_way_merge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">378. Kth Smallest Element in a Sorted Matrix</a>
 */
public class KthSmallestInSortedArrays {

    private static class HeapNode {
        int row;
        int column;
        int value;

        public HeapNode(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        Queue<HeapNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new HeapNode(i, 0, matrix[i][0]));
        }

        HeapNode minNode = null;
        while (k > 0) {
            minNode = minHeap.poll();
            int row = minNode.row;
            int column = minNode.column;
            if (column + 1 < matrix[row].length) {
                minHeap.add(new HeapNode(row, column + 1, matrix[row][column + 1]));
            }
            k--;
        }

        return minNode.value;
    }

    public static void main(String[] args) {
        int[][] ints = {
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        };
        System.out.println("KthSmallestInSortedArrays.kthSmallest(ints, 8) = " + KthSmallestInSortedArrays.kthSmallest(ints, 8));
    }

}
