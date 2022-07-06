package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/synonymous-sentences/">1258. Synonymous Sentences</a>
 */
public class SynonymousSentences {

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> synonym : synonyms) {
            String parent = synonym.get(0);
            String child = synonym.get(1);
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.putIfAbsent(child, new ArrayList<>());

            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        List<String> sentences = new ArrayList<>();
        backtrack(0, text.split(" "), graph, new ArrayList<>(), sentences);
        Collections.sort(sentences);

        return sentences;
    }

    private void backtrack(int index, String[] words, Map<String, List<String>> graph, List<String> currentSentence, List<String> sentences) {
        if (index == words.length) {
            sentences.add(String.join(" ", currentSentence));
        } else {
            String currentWord = words[index];
            if (graph.containsKey(currentWord)) {
                List<String> synonyms = new ArrayList<>();
                dfs(synonyms, currentWord, new HashSet<>(), graph);
                for (String synonym : synonyms) {
                    currentSentence.add(synonym);
                    backtrack(index + 1, words, graph, currentSentence, sentences);
                    currentSentence.remove(currentSentence.size() - 1);
                }
            } else {
                currentSentence.add(currentWord);
                backtrack(index + 1, words, graph, currentSentence, sentences);
                currentSentence.remove(currentSentence.size() - 1);
            }
        }
    }

    private void dfs(List<String> synonyms, String word, Set<String> visited, Map<String, List<String>> graph) {
        visited.add(word);
        synonyms.add(word);
        for (String ngh : graph.get(word)) {
            if (!visited.contains(ngh)) {
                dfs(synonyms, ngh, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        SynonymousSentences synonymousSentences = new SynonymousSentences();
        List<List<String>> synonyms = List.of(List.of("happy", "joy"), List.of("sad", "sorrow"), List.of("joy", "cheerful"));
        List<String> sentences = synonymousSentences.generateSentences(synonyms, "Today is a happy day but yesterday was a sad day");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
