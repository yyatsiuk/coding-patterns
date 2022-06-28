package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/minimum-knight-moves/">1197. Minimum Knight Moves</a>
 */
public class MinimumKnightMoves {

    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        int[][] directions = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[610][610];
        queue.add(new int[]{0, 0});
        visited[300][300] = true;

        int numOfMoves = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] node = queue.remove();
                if (node[0] == x && node[1] == y) return numOfMoves;
                for (int[] dir : directions) {
                    int nextX = node[0] + dir[0];
                    int nextY = node[1] + dir[1];
                    if (((y >= 0 && nextY >= 0) || (y < 0 && nextY < 0))
                            && !visited[nextX + 302][nextY + 302]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX + 302][nextY + 302] = true;
                    }
                }
            }
            numOfMoves++;
        }

        return numOfMoves;
    }

}
