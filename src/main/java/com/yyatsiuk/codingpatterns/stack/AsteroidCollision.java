package com.yyatsiuk.codingpatterns.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/asteroid-collision/">735. Asteroid Collision</a>
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (true) {
                    if (stack.peek() < 0) {
                        stack.push(asteroid);
                        break;
                    } else if (stack.peek() == -asteroid) {
                        stack.pop();
                        break;
                    } else if (stack.peek() > -asteroid) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroid);
                            break;
                        }
                    }
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] ints = asteroidCollision.asteroidCollision(new int[]{1, -1, -2, -2});
        System.out.println(Arrays.toString(ints));
    }


}
