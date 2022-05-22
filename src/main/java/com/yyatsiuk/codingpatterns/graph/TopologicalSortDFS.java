package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://www.baeldung.com/cs/dag-topological-sort#dfs_topology">DFS Based Topological Sorting Algorithm</a>
 */
public class TopologicalSortDFS {

    public List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> order = new ArrayList<>();
        if (vertices <= 0) return order;

        boolean[] visited = new boolean[vertices];
        Map<Integer, Set<Integer>> graph = buildGraph(vertices, edges);
        for (Integer v : graph.keySet()) {
            if (!visited[v]) {
                dfs(graph, visited, order, v);
            }
        }

        return order;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, List<Integer> order, int vertex) {
        visited[vertex] = true;
        for (Integer v : graph.get(vertex)) {
            if (!visited[v]) {
                dfs(graph, visited, order, v);
            }
        }

        order.add(0, vertex);
    }

    private static Map<Integer, Set<Integer>> buildGraph(int vertices, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int v = 0; v < vertices; v++) {
            graph.put(v, new HashSet<>());
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[0];
            graph.get(parent).add(child);
        }

        return graph;
    }


    public static void main(String[] args) {
        TopologicalSortDFS topologicalSort = new TopologicalSortDFS();
        List<Integer> result = topologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = topologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = topologicalSort.sort(7, new int[][]{
                new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3}, new int[]{5, 4},
                new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        System.out.println(result);
    }

}
