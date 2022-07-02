package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/alien-dictionary/">269. Alien Dictionary</a>
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.length() > word2.length() && word1.startsWith(word2)) {
                    return "";
                }
                char w1Ch = word1.charAt(j);
                char w2Ch = word2.charAt(j);
                if (w1Ch != w2Ch) {
                    graph.get(w1Ch).add(w2Ch);
                    break;
                }
            }
        }

        Map<Character, Integer> inDegree = new HashMap<>();
        graph.forEach((ch, adj) -> {
            inDegree.putIfAbsent(ch, 0);
            for (Character child : adj) {
                inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            }
        });

        Queue<Character> queue = new ArrayDeque<>();
        inDegree.forEach((ch, degree) -> {
            if (degree == 0) queue.add(ch);
        });

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.remove();
            sb.append(ch);
            for (Character child : graph.get(ch)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        if (sb.length() != graph.size()) {
            return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String alienOrder = alienDictionary.alienOrder(new String[]{"wrtg", "wrfl", "erp", "ettz", "rfttz"});
        System.out.println(alienOrder);
    }

}
