package com.yyatsiuk.codingpatterns.simulation;

/**
 * <a href="https://leetcode.com/problems/robot-bounded-in-circle/">1041. Robot Bounded In Circle</a>
 */
public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int currentPosition = 0;
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                x += directions[currentPosition][0];
                y += directions[currentPosition][1];
            } else if (ch == 'L') {
                if (currentPosition == 0) currentPosition = 3;
                else currentPosition--;
            } else if (ch == 'R') {
                if (currentPosition == 3) currentPosition = 0;
                else currentPosition++;
            }
        }


        return (x == 0 && y == 0) || currentPosition != 0;
    }

}
