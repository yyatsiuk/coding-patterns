package com.yyatsiuk.codingpatterns.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/">54. Spiral Matrix</a>
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        while (result.size() < n * m) {
            while (j < n && matrix[i][j] != Integer.MAX_VALUE) {
                result.add(matrix[i][j]);
                matrix[i][j++] = Integer.MAX_VALUE;

            }
            j--;
            i++;

            while (i < m && matrix[i][j] != Integer.MAX_VALUE) {
                result.add(matrix[i][j]);
                matrix[i++][j] = Integer.MAX_VALUE;
            }
            i--;
            j--;

            while (j >= 0 && matrix[i][j] != Integer.MAX_VALUE) {
                result.add(matrix[i][j]);
                matrix[i][j--] = Integer.MAX_VALUE;
            }
            j++;
            i--;

            while (i >= 0 && matrix[i][j] != Integer.MAX_VALUE) {
                result.add(matrix[i][j]);
                matrix[i--][j] = Integer.MAX_VALUE;
            }
            i++;
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> integers = spiralMatrix.spiralOrder(ints);
        System.out.println(integers);
    }
}
