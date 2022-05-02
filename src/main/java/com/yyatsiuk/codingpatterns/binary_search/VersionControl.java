package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://leetcode.com/problems/first-bad-version/">278. First Bad Version</a>
 */
public class VersionControl {
    private final int firstBadVersion;

    public VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    private boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {

            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        VersionControl versionControl = new VersionControl(24);
        System.out.println("versionControl.firstBadVersion(552) = " + versionControl.firstBadVersion(120));
    }
}
