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

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] pixel = queue.remove();
            int pSr = pixel[0];
            int pSc = pixel[1];
            image[pSr][pSc] = newColor;

            if (pSr + 1 < n && image[pSr + 1][pSc] == color) {
                queue.add(new int[]{pSr + 1, pSc});
            }

            if (pSr - 1 >= 0 && image[pSr - 1][pSc] == color) {
                queue.add(new int[]{pSr - 1, pSc});
            }

            if (pSc + 1 < m && image[pSr][pSc + 1] == color) {
                queue.add(new int[]{pSr, pSc + 1});
            }

            if (pSc - 1 >= 0 && image[pSr][pSc - 1] == color) {
                queue.add(new int[]{pSr, pSc - 1});
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
