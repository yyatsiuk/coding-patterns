package com.yyatsiuk.codingpatterns.strings;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/">8. String to Integer (atoi)</a>
 */
public class StringToInteger {

    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        int myInt = stringToInteger.myAtoi("-91283472332");
        System.out.println(myInt);

    }
}
