package com.yyatsiuk.codingpatterns.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/max-stack/">716. Max Stack</a>
 */
public class MaxStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> maxStack;

    public MaxStack() {
        this.stack = new ArrayDeque<>();
        this.maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (maxStack.isEmpty()) maxStack.push(x);
        else {
            int max = maxStack.peek();
            maxStack.push(Math.max(max, x));
        }

        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = this.peekMax();
        Deque<Integer> buffer = new LinkedList<>();
        while (stack.peek() != max) {
            buffer.push(this.pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            this.push(buffer.pop());
        }

        return max;
    }

}