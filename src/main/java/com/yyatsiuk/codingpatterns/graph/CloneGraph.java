package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/clone-graph/">133. Clone Graph</a>
 */
public class CloneGraph {

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            for (Node ngh : currentNode.neighbors) {
                if (!visited.containsKey(ngh)) {
                    queue.add(ngh);
                    visited.put(ngh, new Node(ngh.val));
                }
                visited.get(currentNode).neighbors.add(visited.get(ngh));
            }
        }

        return visited.get(node);
    }

}
