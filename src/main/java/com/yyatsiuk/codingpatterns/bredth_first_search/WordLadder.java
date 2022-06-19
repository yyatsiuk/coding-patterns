package com.yyatsiuk.codingpatterns.bredth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-ladder/">127. Word Ladder</a>
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> words = new ArrayList<>(wordList);
        words.add(beginWord);

        Map<String, List<String>> graph = buildGraph(words);
        return bfs(beginWord, graph, endWord);
    }

    private int bfs(String rootNode, Map<String, List<String>> graph, String endWord) {
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(rootNode);
        visited.add(rootNode);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currNode = queue.remove();
                if (currNode.equals(endWord)) {
                    return level;
                }

                List<String> adj = graph.get(currNode);
                for (String node : adj) {
                    if (!visited.contains(node)) {
                        visited.add(node);
                        queue.add(node);
                    }
                }
            }

            level++;
        }

        return 0;
    }

    // O(n^2 * m)
    private Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String word : wordList) {
            graph.put(word, new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String word2 = wordList.get(j);
                if (numberOfDifferentLetters(word1, word2) == 1) {
                    graph.get(word1).add(word2);
                    graph.get(word2).add(word1);
                }
            }
        }

        return graph;
    }

    private int numberOfDifferentLetters(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) if (word1.charAt(i) != word2.charAt(i)) diff++;

        return diff;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();

        int result = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(result);
    }

}
