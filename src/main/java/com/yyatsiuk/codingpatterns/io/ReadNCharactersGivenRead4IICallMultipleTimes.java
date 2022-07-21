package com.yyatsiuk.codingpatterns.io;

import lombok.SneakyThrows;

/**
 * <a href="https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times">158. Read N Characters Given read4 II - Call Multiple Times</a>
 */
public class ReadNCharactersGivenRead4IICallMultipleTimes extends Read4 {

    private final char[] tmpBuff = new char[4];
    private int tmpBuffSize = 0;
    private int tmpBuffPointer = 0;

    public int read(char[] buf, int n) {
        int pointer = 0;
        while (pointer < n) {
            if (tmpBuffPointer == 0) tmpBuffSize = read4(tmpBuff);
            if (tmpBuffSize == 0) return pointer;

            while (pointer < n && tmpBuffPointer < tmpBuffSize) {
                buf[pointer++] = tmpBuff[tmpBuffPointer++];
            }

            if (tmpBuffPointer >= tmpBuffSize) {
                tmpBuffPointer = 0;
            }
        }

        return pointer;
    }

    @SneakyThrows
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 1, 4};
        ReadNCharactersGivenRead4IICallMultipleTimes solution = new ReadNCharactersGivenRead4IICallMultipleTimes();
        for (int num : nums) {
            char[] buf = new char[num];
            int read = solution.read(buf, num);
            System.out.println(read + " " + new String(buf));
        }
    }
}
