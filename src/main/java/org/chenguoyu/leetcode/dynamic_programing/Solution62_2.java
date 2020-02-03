package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 动态规划的解法
 */
public class Solution62_2 {
    /**
     * 可以将问题转化为有多少种方式可以到达m==1或n==1的路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] memory = new int[n][m];
        for (int i = 0; i < n; i++) {
            memory[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            memory[0][i] = 1;
        }
        for (int endY = 1; endY < n; endY++) {
            for (int endX = 1; endX < m; endX++) {
                memory[endY][endX] = memory[endY - 1][endX] + memory[endY][endX - 1];
            }
        }
        return memory[n - 1][m - 1];
    }
}
