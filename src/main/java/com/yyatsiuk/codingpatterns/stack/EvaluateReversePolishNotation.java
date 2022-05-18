package com.yyatsiuk.codingpatterns.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">150. Evaluate Reverse Polish Notation</a>
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Set<String> operations = Set.of("+", "-", "*", "/");
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (operations.contains(token)) {
                int number = stack.pop();
                int sum = stack.pop();
                stack.push(calculate(sum, number, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int calculate(int x, int y, String op) {
        return switch (op) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> throw new IllegalArgumentException("Unsupported operator");
        };
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation eval = new EvaluateReversePolishNotation();
        System.out.println(eval.evalRPN(new String[]{"1", "2", "+", "2", "+", "1", "-"}));
    }

}
