package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/course-schedule-ii/">210. Course Schedule II</a>
 */
public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int parent = prerequisite[1];
            int child = prerequisite[0];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            order[index++] = vertex;
            for (Integer child : graph.get(vertex)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }

        if (index != numCourses) return new int[0];

        return order;
    }

}
