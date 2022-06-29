package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        final String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                start.append(ints[j]);
            }
        }

        int[][] positions = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(start.toString());
        visited.add(start.toString());

        int moves = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String boardState = queue.remove();
                if (boardState.equals(target)) return moves;
                int zeroIndex = boardState.indexOf("0");
                for (int dir : positions[zeroIndex]) {
                    String nextState = swap(boardState, zeroIndex, dir);
                    if (!visited.contains(nextState)) {
                        queue.add(nextState);
                        visited.add(nextState);
                    }
                }
            }
            moves++;

        }

        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        SlidingPuzzle solve = new SlidingPuzzle();
        int i = solve.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 1}});
        System.out.println(i);
    }
}
