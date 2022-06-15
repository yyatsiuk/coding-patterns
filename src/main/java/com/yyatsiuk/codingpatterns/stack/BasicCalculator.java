package com.yyatsiuk.codingpatterns.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/basic-calculator/">224. Basic Calculator</a>
 */
public class BasicCalculator {


    public int calculate(String s) {
        int len = s.length();
        int sign = 1;
        int result = 0;

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        int result = basicCalculator.calculate("10+2-(5+6+11)-(1+2)");
        System.out.println(result);
    }

}
