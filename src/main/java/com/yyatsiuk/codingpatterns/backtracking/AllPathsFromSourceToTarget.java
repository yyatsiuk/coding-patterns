package com.yyatsiuk.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">797. All Paths From Source to Target</a>
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        allPathsSourceTarget(graph, 0, path, result);
        return result;
    }

    private void allPathsSourceTarget(int[][] graph, int vertex, List<Integer> path, List<List<Integer>> allPaths) {
        if (vertex == graph.length - 1) {
            allPaths.add(new ArrayList<>(path));
            return;
        }

        for (int childVertex : graph[vertex]) {
            path.add(childVertex);
            allPathsSourceTarget(graph, childVertex, path, allPaths);
            path.remove(path.size() - 1);
        }
    }

}
