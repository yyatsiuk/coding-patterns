package com.yyatsiuk.codingpatterns.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class BasicCalculator {


    public int calculate(String s) {
        if (s == null || s.isBlank()) {
            return 0;
        }

        String normalizedExpression = normalize(s);
        StringBuilder stringBuilder = openParentheses(new StringBuilder(normalizedExpression));

        return Integer.parseInt(calculateExp(stringBuilder.toString()));
    }

    private String normalize(String s) {
        return s.replace(" ", "")
                .replace("+", " + ")
                .replace("-", " - ")
                .strip();
    }

    private StringBuilder openParentheses(StringBuilder str) {
        int lastOpen = str.lastIndexOf("(");
        if (lastOpen == -1) {
            return str;
        }
        int lastClose = str.indexOf(")", lastOpen);

        String expression = str.substring(lastOpen + 1, lastClose);
        String result = calculateExp(expression);

        str.delete(lastOpen, lastClose + 1);
        str.insert(lastOpen, result);


        return openParentheses(str);
    }

    private String calculateExp(String expression) {
        String[] tokenizedExpression = expression.split(" ");
        if (tokenizedExpression.length == 1) {
            return tokenizedExpression[0];
        }

        Deque<String> queue = new ArrayDeque<>();
        for (String token : tokenizedExpression) {
            if ("".equals(token)) {
                queue.add("0");
            } else {
                queue.add(token);
            }
        }

        String num1, num2, operator;
        while (queue.size() > 1) {
            num1 = queue.removeFirst();
            if (Set.of("-", "+").contains(num1)) {
                operator = num1;
                num1 = "0";
            } else {
                operator = queue.removeFirst();
            }
            num2 = queue.removeFirst();

            final int result;
            if ("+".equals(operator)) {
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
            } else {
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
            }

            queue.addFirst(String.valueOf(result));
        }

        return queue.remove();
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        int result = basicCalculator.calculate("1-(-2)");
        System.out.println(result);
    }

}
