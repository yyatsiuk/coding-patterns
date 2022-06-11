package com.yyatsiuk.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    private final List<String> permutations = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        letterCasePermutation(s, new StringBuilder(), 0);
        return permutations;
    }

    private void letterCasePermutation(String s, StringBuilder strBld, int index) {
        if (index >= s.length()) {
            permutations.add(strBld.toString());
            return;
        }

        char ch = s.charAt(index);
        if (Character.isLetter(ch)) {
            letterCasePermutation(s, strBld.append(Character.toUpperCase(ch)), index + 1);
            strBld.deleteCharAt(strBld.length() - 1);
            letterCasePermutation(s, strBld.append(Character.toLowerCase(ch)), index + 1);
        } else {
            letterCasePermutation(s, strBld.append(ch), index + 1);
        }
        strBld.deleteCharAt(strBld.length() - 1);
    }

    public static void main(String[] args) {
        LetterCasePermutation permutation = new LetterCasePermutation();
        List<String> abC = permutation.letterCasePermutation("AbC");
        System.out.println(abC);
    }

}
