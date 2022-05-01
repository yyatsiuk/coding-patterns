package com.yyatsiuk.codingpatterns.top_k;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-frequency-stack/solution/">895. Maximum Frequency Stack</a>
 */
public class FreqStack {

    private static class StackElement {
        int val;
        int freq;
        int sequenceNumber;

        public StackElement(int val, int freq, int sequenceNumber) {
            this.val = val;
            this.freq = freq;
            this.sequenceNumber = sequenceNumber;
        }
    }

    private final Queue<StackElement> maxHeap;
    private final Map<Integer, Integer> frequencyMap;
    private int sequence;

    public FreqStack() {
        this.maxHeap = new PriorityQueue<>((e1, e2) -> {
            if (e2.freq - e1.freq == 0) {
                return e2.sequenceNumber - e1.sequenceNumber;
            }

            return e2.freq - e1.freq;
        });
        this.frequencyMap = new HashMap<>();
        this.sequence = 0;
    }

    public void push(int val) {
        frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
        maxHeap.add(new StackElement(val, frequencyMap.get(val), sequence++));
    }

    public int pop() {
        int num = maxHeap.poll().val;

        if (frequencyMap.get(num) > 1)
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        else
            frequencyMap.remove(num);

        return num;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println("freqStack.pop() = " + freqStack.pop());
        System.out.println("freqStack.pop() = " + freqStack.pop());
        System.out.println("freqStack.pop() = " + freqStack.pop());
        System.out.println("freqStack.pop() = " + freqStack.pop());
    }
}
