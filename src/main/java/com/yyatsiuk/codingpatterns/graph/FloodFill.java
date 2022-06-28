package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/flood-fill/">733. Flood Fill</a>
 */
public class FloodFill {

    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private record Pixel(int sr, int sc) {
    }

    private List<Pixel> getNeighbors(int[][] image, Pixel pixel, int rootColor, int numRows, int numCols) {
        List<Pixel> pixels = new ArrayList<>();
        for (int[] direction : DIRECTIONS) {
            int newR = pixel.sr() + direction[0];
            int newC = pixel.sc() + direction[1];
            if (newR >= 0 && newR < numRows &&
                    newC >= 0 && newC < numCols &&
                    image[newR][newC] == rootColor) {

                pixels.add(new Pixel(newR, newC));
            }
        }

        return pixels;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int numRows = image.length;
        int numCols = image[0].length;
        int rootColor = image[sr][sc];
        Queue<Pixel> queue = new ArrayDeque<>();
        queue.add(new Pixel(sr, sc));
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {
            Pixel pixel = queue.remove();
            for (Pixel ngh : getNeighbors(image, pixel, rootColor, numRows, numCols)) {
                queue.add(ngh);
                image[ngh.sr()][ngh.sc()] = newColor;
            }
        }

        return image;
    }

}
