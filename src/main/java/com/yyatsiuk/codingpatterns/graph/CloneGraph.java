package com.yyatsiuk.codingpatterns.graph;

import com.yyatsiuk.codingpatterns.common.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/clone-graph/">133. Clone Graph</a>
 */
public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        Map<GraphNode, GraphNode> visited = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new GraphNode(node.val));

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            for (GraphNode ngh : currentNode.neighbors) {
                if (!visited.containsKey(ngh)) {
                    queue.add(ngh);
                    visited.put(ngh, new GraphNode(ngh.val));
                }
                visited.get(currentNode).neighbors.add(visited.get(ngh));
            }
        }

        return visited.get(node);
    }

}
