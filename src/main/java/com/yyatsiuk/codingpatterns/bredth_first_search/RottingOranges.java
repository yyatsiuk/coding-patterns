package com.yyatsiuk.codingpatterns.bredth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countFresh = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        if (countFresh == 0) return 0;

        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = -1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] location = queue.remove();
                int x = location[0];
                int y = location[1];
                for (int[] dir : direction) {
                    int xNext = x + dir[0];
                    int yNext = y + dir[1];
                    if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < m && grid[xNext][yNext] == 1) {
                        queue.add(new int[]{xNext, yNext});
                        grid[xNext][yNext] = 2;
                        countFresh--;
                    }
                }
            }
            time++;
        }

        return countFresh == 0 ? time : -1;
    }

}
