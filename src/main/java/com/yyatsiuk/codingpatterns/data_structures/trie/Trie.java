package com.yyatsiuk.codingpatterns.data_structures.trie;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.setNode(ch, new TrieNode());
            }
            node = node.getNode(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode prefix = searchPrefix(word);
        return prefix != null && prefix.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) return null;

            node = node.getNode(ch);
        }

        return node;
    }

}
