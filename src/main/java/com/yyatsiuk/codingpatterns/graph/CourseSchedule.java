package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/course-schedule/">207. Course Schedule</a>
 */
public class CourseSchedule {

    private static class Graph {

        private final int vertexes;
        private final List<Integer>[] adj;
        private final int[] indegree;

        @SuppressWarnings("unchecked")
        public Graph(int vertexes, int[][] edges) {
            this.vertexes = vertexes;
            this.indegree = new int[vertexes];
            this.adj = new ArrayList[vertexes];

            for (int v = 0; v < vertexes; v++) {
                adj[v] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                adj[from].add(to);
                indegree[to]++;
            }
        }

        public int getVertexes() {
            return vertexes;
        }

        public List<Integer>[] getAdj() {
            return adj;
        }

        public int[] getIndegree() {
            return indegree;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses, prerequisites);
        List<Integer> topologicalOrder = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        int[] indegree = graph.getIndegree();
        for (int v = 0; v < graph.getVertexes(); v++) {
            if (indegree[v] == 0) queue.add(v);
        }

        List<Integer>[] adj = graph.getAdj();
        while (!queue.isEmpty()) {
            Integer from = queue.remove();
            topologicalOrder.add(from);
            for (Integer to : adj[from]) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    queue.add(to);
                }
            }
        }

        return topologicalOrder.size() == numCourses;
    }
}
