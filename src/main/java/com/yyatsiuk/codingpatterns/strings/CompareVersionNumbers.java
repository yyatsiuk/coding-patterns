package com.yyatsiuk.codingpatterns.strings;

/**
 * <a href="https://leetcode.com/problems/compare-version-numbers/">165. Compare Version Numbers</a>
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] revisions = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        for (int i = 0; i < Math.max(revisions.length, revisions2.length); i++) {
            int v1 = i >= revisions.length ? 0 : Integer.parseInt(revisions[i]);
            int v2 = i >= revisions2.length ? 0 : Integer.parseInt(revisions2[i]);
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers test = new CompareVersionNumbers();
        int r1 = test.compareVersion("0.1", "1.0");
        System.out.println(r1);
        int r2 = test.compareVersion("1.01", "1.001");
        System.out.println(r2);
        int r3 = test.compareVersion("1.0.1", "1");
        System.out.println(r3);
        int r4 = test.compareVersion("7.5.2.4", "7.5.3");
        System.out.println(r4);
    }
}

