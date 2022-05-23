package com.yyatsiuk.codingpatterns.trie;

public class TrieNode {

    private final TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[26];
    }

    public void setNode(char ch, TrieNode node) {
        this.links[ch - 'a'] = node;
    }

    public boolean containsKey(char ch) {
        return this.links[ch - 'a'] != null;
    }

    public TrieNode getNode(char ch) {
        return this.links[ch - 'a'];
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
