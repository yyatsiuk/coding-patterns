package com.yyatsiuk.codingpatterns.bit_manipulations;

/**
 * <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">779. K-th Symbol in Grammar</a>
 */
public class KthSymbolInGrammar {

    /**
     * <a href="https://www.youtube.com/watch?v=QRa9ZVGMWlY">Solution Video</a>
     * Time Complexity: N
     * Space Complexity: N
     */
    public int kthGrammar(int n, int k) {
        if (n == 1 || k == 1) {
            return 0;
        }

        int parent = kthGrammar(n - 1, (int) Math.round(k / 2.0));
        boolean isKOdd = k % 2 == 1;
        if (parent == 1) {
            return isKOdd ? 1 : 0;
        } else {
            return isKOdd ? 0 : 1;
        }
    }

    public static void main(String[] args) {
        KthSymbolInGrammar kthSymbolInGrammar = new KthSymbolInGrammar();
        int result = kthSymbolInGrammar.kthGrammar(8, 4);
        System.out.println(result);
    }
}
