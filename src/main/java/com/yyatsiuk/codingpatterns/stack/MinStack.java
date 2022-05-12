package com.yyatsiuk.codingpatterns.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <a href="https://leetcode.com/problems/min-stack/">155. Min Stack</a>
 */
public class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

        stack.push(val);
    }

    public void pop() {
        Integer topItem = stack.pop();
        if (topItem.equals(minStack.peek())) {
            minStack.removeFirst();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
