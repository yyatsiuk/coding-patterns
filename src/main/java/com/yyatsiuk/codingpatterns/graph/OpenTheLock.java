package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <a fref="https://leetcode.com/problems/open-the-lock/">752. Open the Lock</a>
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new ArrayDeque<>();

        String start = "0000";
        if (visited.contains(start)) return -1;

        queue.add(start);
        visited.add(start);
        int numberOfComb = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String node = queue.remove();
                if (target.equals(node)) return numberOfComb;
                for (int j = 0; j < 4; j++) {
                    String newComb = plusOne(node, j);
                    if (!visited.contains(newComb)) {
                        queue.add(newComb);
                        visited.add(newComb);
                    }

                    newComb = minusOne(node, j);
                    if (!visited.contains(newComb)) {
                        queue.add(newComb);
                        visited.add(newComb);
                    }
                }
            }
            numberOfComb++;
        }

        return -1;
    }

    private String plusOne(String s, int i) {
        char[] c = s.toCharArray();
        if (c[i] == '9') c[i] = '0';
        else c[i] += 1;
        return new String(c);
    }

    private String minusOne(String s, int i) {
        char[] c = s.toCharArray();
        if (c[i] == '0') c[i] = '9';
        else c[i] -= 1;
        return new String(c);
    }


    public static void main(String[] args) {
        OpenTheLock openTheLock = new OpenTheLock();
        int i = openTheLock.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }

}
