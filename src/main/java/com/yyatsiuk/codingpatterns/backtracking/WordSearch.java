package com.yyatsiuk.codingpatterns.backtracking;

public class WordSearch {

    private char[][] board;
    private String word;
    private int wordLength;
    private int m;
    private int n;

    /**
     * Time Complexity: O(m * n * 4^len(word))
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.wordLength = word.length();
        this.m = board.length;
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean exist(int r, int c, int index) {
        if (index == wordLength) return true;

        if (r < 0 || c < 0 || r >= m || c >= n || word.charAt(index) != board[r][c]) return false;

        board[r][c] = '#';
        boolean res =
                exist(r + 1, c, index + 1) ||
                exist(r - 1, c, index + 1) ||
                exist(r, c + 1, index + 1) ||
                exist(r, c - 1, index + 1);
        board[r][c] = word.charAt(index);
        return res;
    }

}
