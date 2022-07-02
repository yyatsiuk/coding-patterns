package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/sequence-reconstruction/">444. Sequence Reconstruction</a>
 */
public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int[] inDegree = new int[nums.length + 1];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i <= nums.length; i++) graph.add(new ArrayList<>());

        for (List<Integer> sequence : sequences) {
            for (int i = 0; i < sequence.size() - 1; i++) {
                int parent = sequence.get(i);
                int child = sequence.get(i + 1);
                graph.get(parent).add(child);
                inDegree[child]++;
            }
        }

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            for (Integer child : graph.get(queue.remove())) {
                inDegree[child]--;
                if (inDegree[child] == 0) queue.add(child);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        boolean res = sequenceReconstruction.sequenceReconstruction(new int[]{1, 2, 3}, List.of(
                List.of(1, 2), List.of(1, 3), List.of(2, 3)
        ));
        System.out.println(res);

    }

}
