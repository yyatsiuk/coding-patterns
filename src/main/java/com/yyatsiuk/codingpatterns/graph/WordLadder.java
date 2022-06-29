package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/word-ladder/">127. Word Ladder</a>
 */
public class WordLadder {

    private static final char[] ALPHABETS = new char[26];

    static {
        for (int i = 0; i < 26; i++) {
            ALPHABETS[i] = (char) (i + 'a');
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        int distance = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String word = queue.remove();
                if (Objects.equals(word, endWord)) return distance;
                for (char letter : ALPHABETS) {
                    for (int j = 0; j < word.length(); j++) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(j, letter);
                        String nextWord = sb.toString();
                        if (words.contains(nextWord)) {
                            queue.add(nextWord);
                            words.remove(nextWord);
                        }
                    }
                }
            }
            distance++;
        }

        return 0;
    }


}
