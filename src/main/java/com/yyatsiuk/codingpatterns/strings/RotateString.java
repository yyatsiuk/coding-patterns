package com.yyatsiuk.codingpatterns.strings;

/**
 * <a href="https://leetcode.com/problems/rotate-string/">796. Rotate String</a>
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String s1s1 = s + s;
        return s1s1.contains(goal);
    }

}
