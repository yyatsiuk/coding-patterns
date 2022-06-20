package com.yyatsiuk.codingpatterns.bredth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/water-and-jug-problem/">365. Water and Jug Problem</a>
 */
public class WaterAndJugProblemBFS {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] options = new int[]{x, y, -x, -y};
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == z) return true;
            for (int o : options) {
                int next = cur + o;
                if (next > 0 && next <= x + y && !visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }

}
