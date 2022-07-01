package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/parallel-courses-iii/">2050. Parallel Courses III</a>
 */
public class ParallelCourses3 {

    public int minimumTime(int n, int[][] relations, int[] time) {
        int months = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int parent = relations[i][0];
            int child = relations[i][1];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                dist[i] = time[i - 1];
                months = Math.max(months, dist[i]);
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.remove();
            for (Integer child : graph.get(course)) {
                inDegree[child]--;
                dist[child] = Math.max(dist[child], dist[course] + time[child - 1]);
                months = Math.max(months, dist[child]);
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }

        return months;
    }

}
