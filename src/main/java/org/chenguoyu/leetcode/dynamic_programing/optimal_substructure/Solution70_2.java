package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;

/**
 * 动态规划的解法
 */
public class Solution70_2 {
    public int climbStairs(int n) {
        int[] memory = new int[n + 1];
        memory[0] = 1;
        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }
}
