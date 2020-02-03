package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 动态规划的解法
 */
public class Solution279_1 {
    Integer[] memory;

    public int numSquares(int n) {
        memory = new Integer[n + 1];
        return squaresNum(n);
    }

    private int squaresNum(int n) {
        if (n == 1) {
            return 1;
        }
        if (memory[n] == null) {
            memory[n] = n;
            for (int i = 1; i * i <= n; i++) {
                if (n == i * i) {
                    memory[n] = 1;
                } else {
                    memory[n] = Math.min(squaresNum(n - (i * i)) + 1, memory[n]);
                }
            }
        }
        return memory[n];
    }
}
