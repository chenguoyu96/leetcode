package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 记忆化搜索的解法
 */
public class Solution62_1 {
    private Integer[][] memory;

    /**
     * 可以将问题转化为有多少种方式可以到达m==1或n==1的路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        memory = new Integer[n + 1][m + 1];
        return uniquePath(m, n);
    }

    private int uniquePath(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        if (memory[n][m] == null) {
            memory[n][m] = uniquePath(m, n - 1) + uniquePath(m - 1, n);
        }
        return memory[n][m];
    }
}
