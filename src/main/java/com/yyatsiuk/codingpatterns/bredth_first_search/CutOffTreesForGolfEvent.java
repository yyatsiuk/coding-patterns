package com.yyatsiuk.codingpatterns.bredth_first_search;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/cut-off-trees-for-golf-event/">675. Cut Off Trees for Golf Event</a>
 */
public class CutOffTreesForGolfEvent {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {

        List<int[]> treeHeights = getAllTreeHeights(forest);
        treeHeights.sort(Comparator.comparingInt(o -> o[2]));

        int minSteps = 0;
        int curX = 0, curY = 0;
        while (!treeHeights.isEmpty()) {
            int[] curTree = treeHeights.remove(0);
            int steps = getMinimumSteps(forest, curX, curY, curTree[0], curTree[1]);
            if (steps == -1) {
                return -1;
            }

            minSteps += steps;
            curX = curTree[0];
            curY = curTree[1];
            forest.get(curX).set(curY, 1);
        }

        return minSteps;
    }

    private int getMinimumSteps(List<List<Integer>> forest, int curX, int curY, int aimX, int aimY) {
        int minSteps = 0;
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{curX, curY});
        visited[curX][curY] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curCell = queue.remove();
                if (curCell[0] == aimX && curCell[1] == aimY) {
                    return minSteps;
                }
                for (int[] direction : directions) {
                    int nx = curCell[0] + direction[0];
                    int ny = curCell[1] + direction[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && forest.get(nx).get(ny) != 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    private List<int[]> getAllTreeHeights(List<List<Integer>> forest) {
        List<int[]> treeHeights = new LinkedList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int value = forest.get(i).get(j);
                if (value > 1) {
                    int[] element = new int[3];
                    element[0] = i;
                    element[1] = j;
                    element[2] = value;
                    treeHeights.add(element);
                }
            }
        }
        return treeHeights;
    }

}
