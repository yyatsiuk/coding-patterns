package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="">844. Backspace String Compare</a>
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * <b>Example 1:</b>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * <p>
 * <b>Example 2:</b>
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * <p>
 * <b>Example 3:</b>
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */
@Slf4j
public class BackspaceCompare {

    // Approach #1: Two Pointer
    public static boolean backspaceCompareTwoPointers(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(str1) or build (T)
            while (i >= 0) { // Find position of next possible char in build(str1)
                if (str1.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (str2.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && str1.charAt(i) != str2.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }

    // Approach #2: Build String
    public static boolean backspaceCompare(String s, String t) {
        String s1 = convert(s);
        String s2 = convert(t);


        return s1.equals(s2);
    }

    private static String convert(String str) {
        Deque<Character> charsQueue = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.charAt(i) != '#') {
                charsQueue.add(ch);
            } else {
                charsQueue.pollLast();
            }
        }

        return String.valueOf(charsQueue);
    }


    public static void main(String[] args) {
        log.info("Result = {}", backspaceCompareTwoPointers("xy#z", "xzz#"));
        log.info("Result = {}", backspaceCompareTwoPointers("xy#z", "xyz#"));
        log.info("Result = {}", backspaceCompareTwoPointers("xp#", "xyz##"));
        log.info("Result = {}", backspaceCompareTwoPointers("xywrrmp", "xywrrmu#p"));
    }
}
