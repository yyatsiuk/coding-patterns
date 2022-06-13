package com.yyatsiuk.codingpatterns.subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {


    private record ParenthesesString(String str, int openCount, int closeCount) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new ArrayDeque<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            if (ps.openCount == n && ps.closeCount == n) {
                result.add(ps.str);
            } else {
                if (ps.openCount < n) {
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
                }

                if (ps.openCount > ps.closeCount) {
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses solve = new GenerateParentheses();
        List<String> result = solve.generateParenthesis(15);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

}
