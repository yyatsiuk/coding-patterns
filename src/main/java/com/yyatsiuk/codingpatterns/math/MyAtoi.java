package com.yyatsiuk.codingpatterns.math;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/">8. String to Integer (atoi)</a>
 */
public class MyAtoi {

    public int myAtoi(String s) {
        if (s.isBlank()) return 0;

        int n = s.length();
        int sign = 1;
        int index = 0;

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index < n && s.charAt(index) == '-' || s.charAt(index) == '+') {
            sign = s.charAt(index) == '-' ? -1 : sign;
            index++;
        }

        int number = 0;
        int boundary = Integer.MAX_VALUE / 10;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if ((number > boundary) || (number == boundary && digit > Integer.MAX_VALUE % 10)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            number = number * 10 + digit;
            index++;
        }

        return number * sign;
    }

    public static void main(String[] args) {
        MyAtoi stringToInteger = new MyAtoi();
        int myInt = stringToInteger.myAtoi("-91283472332");
        System.out.println(myInt);

    }
}
