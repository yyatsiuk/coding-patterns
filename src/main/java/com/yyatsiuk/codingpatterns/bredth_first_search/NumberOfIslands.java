package com.yyatsiuk.codingpatterns.bredth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
 */
public class NumberOfIslands {

    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int countOfIslands = 0;
        Queue<int[]> neighbors = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    neighbors.add(new int[]{i, j});
                    grid[i][j] = '0';
                    countOfIslands++;
                    while (!neighbors.isEmpty()) {
                        int[] cell = neighbors.remove();
                        int x = cell[0];
                        int y = cell[1];
                        for (int[] dir : directions) {
                            int xNext = x + dir[0];
                            int yNext = y + dir[1];
                            if ((xNext < n && xNext >= 0) && (yNext < m && yNext >= 0) && grid[xNext][yNext] == '1') {
                                neighbors.add(new int[]{xNext, yNext});
                                grid[xNext][yNext] = '0';
                            }
                        }
                    }
                }
            }
        }

        return countOfIslands;
    }

}
