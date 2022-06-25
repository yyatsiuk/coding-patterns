package com.yyatsiuk.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">17. Letter Combinations of a Phone Number</a>
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, char[]> KEYBOARD = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isBlank()) {
            return result;
        }

        letterCombinations(0, digits, new StringBuilder(), result);
        return result;
    }

    private void letterCombinations(int index, String digits, StringBuilder sb, List<String> result) {
        if (index >= digits.length()) {
            result.add(sb.toString());
        } else {

            for (char ch : KEYBOARD.get(digits.charAt(index))) {
                sb.append(ch);
                letterCombinations(index + 1, digits, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber combinations = new LetterCombinationsOfAPhoneNumber();
        List<String> strings = combinations.letterCombinations("23");
        System.out.println(strings);
    }

}
