package com.yyatsiuk.codingpatterns.io;

import lombok.SneakyThrows;

/**
 * <a href="https://leetcode.com/problems/read-n-characters-given-read4/">157. Read N Characters Given Read4</a>
 */
public class ReadNCharactersGivenRead4 extends Read4 {

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int pointer = 0;
        int bufferPointer = 0;
        int bufferSize = 0;

        while (pointer < n) {
            bufferSize = read4(buffer);
            if (bufferSize == 0) return pointer;

            while (pointer < n && bufferPointer < bufferSize) {
                buf[pointer++] = buffer[bufferPointer++];
            }

            bufferPointer = 0;
        }

        return pointer;
    }

    @SneakyThrows
    public static void main(String[] args) {
        ReadNCharactersGivenRead4 solution = new ReadNCharactersGivenRead4();
        char[] buf = new char[10];
        int read = solution.read(buf, 10);
        System.out.println(read + " " + new String(buf));
    }

}
