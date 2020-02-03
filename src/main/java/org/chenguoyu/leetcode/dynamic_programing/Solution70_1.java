package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 记忆化搜索的解法
 */
public class Solution70_1 {
    private int[] memory;

    public int climbStairs(int n) {
        memory = new int[n + 1];
        return climbWays(n);
    }

    private int climbWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memory[n] == 0) {
            memory[n] = climbWays(n - 1) + climbWays(n - 2);
        }
        return memory[n];
    }
}
