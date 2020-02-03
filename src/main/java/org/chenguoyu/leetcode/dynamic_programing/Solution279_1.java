package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 动态规划的解法
 */
public class Solution279_2 {
    public int integerBreak(int n) {
        int[] memory = new int[n + 1];
        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memory[i] = max3(memory[i], j * (i - j), memory[i - j] * j);
            }
        }
        return memory[n];
    }


    private int max3(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}
