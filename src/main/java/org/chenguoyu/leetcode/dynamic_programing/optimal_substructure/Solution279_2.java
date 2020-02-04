package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;

/**
 * 动态规划的解法
 */
public class Solution279_2 {
    public int numSquares(int n) {
        int[] memory = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            memory[i] = i;
            for (int j = 1; j * j <= i; j++) {
                memory[i] = Math.min(memory[i], memory[i - j * j] + 1);
            }
        }
        return memory[n];
    }
}
