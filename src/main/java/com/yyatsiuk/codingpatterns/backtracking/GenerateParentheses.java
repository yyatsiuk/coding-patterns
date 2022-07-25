package com.yyatsiuk.codingpatterns.backtracking;

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


    public List<String> generateParenthesisBacktracking(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, new StringBuilder(), result, n);
        return result;
    }

    private void backtrack(int open, int close, StringBuilder sb, List<String> result, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append("(");
            backtrack(open + 1, close, sb, result, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(open, close + 1, sb, result, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solve = new GenerateParentheses();
        List<String> result = solve.generateParenthesisBacktracking(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

}
