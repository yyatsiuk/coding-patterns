package com.yyatsiuk.codingpatterns.top_k;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/reorganize-string/">767. Reorganize String</a>
 */
public class RearrangeString {

    public static String rearrangeString(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        maxHeap.addAll(freqMap.entrySet());

        StringBuilder rearrangedString = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            if (prev != null && prev.getValue() > 0) {
                maxHeap.add(prev);
            }

            rearrangedString.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            prev = entry;
        }

        return rearrangedString.length() == str.length() ? rearrangedString.toString() : "";
    }

    public static void main(String[] args) {
//        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
//        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }

}
