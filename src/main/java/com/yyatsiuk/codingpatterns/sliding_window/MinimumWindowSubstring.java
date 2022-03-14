package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern) {
        int windowStart = 0;
        String smallestSubstring = "";
        String substring = "";


        return smallestSubstring;
    }


    public static void main(String[] args) {
        String substr = MinimumWindowSubstring.findSubstring("aabdec", "abc");
        System.out.println(substr);
    }

}
