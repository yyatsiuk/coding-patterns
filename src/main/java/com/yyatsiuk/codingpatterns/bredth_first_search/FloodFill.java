package com.yyatsiuk.codingpatterns.bredth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/flood-fill/">733. Flood Fill</a>
 */
public class FloodFill {

    // BFS Solution
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int color = image[sr][sc];
        if (color == newColor) return image;

        final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        image[sr][sc] = newColor;
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            for (int[] dir : directions) {
                int newSr = pixel[0] + dir[0];
                int newSc = pixel[1] + dir[1];
                if (newSr >= 0 && newSr < n && newSc >= 0 && newSc < m && image[newSr][newSc] == color) {
                    image[newSr][newSc] = newColor;
                    queue.add(new int[]{newSr, newSc});
                }
            }
        }

        return image;
    }

    // DFS Solution
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }

}
