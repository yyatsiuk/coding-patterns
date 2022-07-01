package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/parallel-courses/">1136. Parallel Courses</a>
 */
public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] relation : relations) {
            int parent = relation[0];
            int child = relation[1];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        for (int i = 1; i <= n; i++) if (inDegree[i] == 0) queue.add(i);

        int semesters = 0;
        int courses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                courses++;
                for (Integer child : graph.get(queue.remove())) {
                    inDegree[child]--;
                    if (inDegree[child] == 0) queue.add(child);
                }
            }
            semesters++;
        }

        if (courses != n) return -1;

        return semesters;
    }


    public static void main(String[] args) {
        ParallelCourses parallelCourses = new ParallelCourses();
        int n = 13;
        int[][] dependencies = new int[][]{{12, 8}, {2, 4}, {3, 7}, {6, 8}, {11, 8}, {9, 4}, {9, 7}, {12, 4}, {11, 4}, {6, 4}, {1, 4}, {10, 7}, {10, 4}, {1, 7}, {1, 8}, {2, 7}, {8, 4}, {10, 8}, {12, 7}, {5, 4}, {3, 4}, {11, 7}, {7, 4}, {13, 4}, {9, 8}, {13, 8}};
        int res = parallelCourses.minimumSemesters(n, dependencies);
        System.out.println(res);

    }
}
