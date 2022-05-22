package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://www.baeldung.com/cs/dag-topological-sort#algorithm">Kahn’s Algorithm</a>
 */
public class TopologicalSortKahn {

    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        int[] inDegree = new int[vertices];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int v = 0; v < vertices; v++) {
            graph.put(v, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < vertices; v++) {
            if (inDegree[v] == 0) {
                queue.add(v);
            }
        }

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            sortedOrder.add(vertex);
            for (Integer v : graph.get(vertex)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        TopologicalSortKahn topologicalSortKahn = new TopologicalSortKahn();

        List<Integer> result = topologicalSortKahn.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = topologicalSortKahn.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = topologicalSortKahn.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
                new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        System.out.println(result);
    }

}
