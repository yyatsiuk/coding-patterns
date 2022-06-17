package com.yyatsiuk.codingpatterns.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/basic-calculator-ii/">227. Basic Calculator II</a>
 */
public class BasicCalculator2 {

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char operation = '+';
        int currentNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }

                operation = ch;
                currentNumber = 0;
            }
        }

        while (!stack.isEmpty()) {
            currentNumber += stack.pop();
        }

        return currentNumber;
    }

    public static void main(String[] args) {
        BasicCalculator2 basicCalculator2 = new BasicCalculator2();
        int calculate = basicCalculator2.calculate("2+3*2-2-0");
        System.out.println(calculate);
    }

}
