package com.yyatsiuk.codingpatterns.math;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">12. Integer to Roman</a>
 */
public class IntegerToRoman {

    private final List<String> romanNumbers = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
    private final List<Integer> classicNumbers = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while (num > 0) {
            if (num - classicNumbers.get(index) >= 0) {
                num -= classicNumbers.get(index);
                sb.append(romanNumbers.get(index));
            } else {
                index++;
            }
        }

        return sb.toString();
    }
}
