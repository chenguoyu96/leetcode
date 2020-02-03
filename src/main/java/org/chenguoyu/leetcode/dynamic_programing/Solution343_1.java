package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 记忆化搜索的解法
 */
public class Solution343_1 {
    Integer[] memory;

    public int integerBreak(int n) {
        memory = new Integer[n + 1];
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memory[n] == null) {
            int result = 0;
            for (int i = 1; i <= n; i++) {
                result = max3(result, (n - i) * i, breakInteger(n - i) * i);
            }
            memory[n] = result;
            return result;
        }
        return memory[n];
    }

    private int max3(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}
