package com.yyatsiuk.codingpatterns.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-ii/">503. Next Greater Element II</a>
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] arr) {
        int[] nextGrater = new int[arr.length];
        Arrays.fill(nextGrater, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nextGrater[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nextGrater[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return nextGrater;
    }

    public static void main(String[] args) {
        NextGreaterElementII monotonousStack = new NextGreaterElementII();
        int[] ints = monotonousStack.nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ints));
    }
}
