package com.yyatsiuk.codingpatterns.bredth_first_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="542. 01 Matrix">https://leetcode.com/problems/01-matrix/</a>
 */
public class ZeroOneMatrix {

    /**
     * Time Complexity: O(n * m)
     * Space Complexity O(n * m) (for Queue)
     */
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int x = cell[0];
            int y = cell[1];
            for (int[] dir : direction) {
                int xNext = x + dir[0];
                int yNext = y + dir[1];
                if ((xNext < n && xNext >= 0) && (yNext < m && yNext >= 0) && !visited[xNext][yNext]) {
                    queue.add(new int[]{xNext, yNext});
                    mat[xNext][yNext] = mat[x][y] + 1;
                    visited[xNext][yNext] = true;
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();
        long start = System.currentTimeMillis();
        int[][] ints = zeroOneMatrix.updateMatrix(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}});
        System.out.println(Arrays.deepToString(ints));
        System.out.println(System.currentTimeMillis() - start);
    }
}


