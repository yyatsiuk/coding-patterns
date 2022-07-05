package com.yyatsiuk.codingpatterns.prefix_sum;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">304. Range Sum Query 2D - Immutable</a>
 */
public class RangeSumQuery2D {

    private final int[][] pSum;

    public RangeSumQuery2D(int[][] matrix) {
        this.pSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                pSum[row + 1][col + 1] = (pSum[row][col + 1] + pSum[row + 1][col]) - pSum[row][col] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pSum[row2 + 1][col2 + 1] - pSum[row1][col2 + 1] - pSum[row2 + 1][col1] + pSum[row1][col1];
    }

    public static void main(String[] args) {
        RangeSumQuery2D sumQuery2D = new RangeSumQuery2D(new int[][]{
                {2, 1, 3},
                {4, 5, 6},
                {7, 3, 5}
        });

        int sum = sumQuery2D.sumRegion(1, 1, 2, 2);
        System.out.println(sum);
    }
}
