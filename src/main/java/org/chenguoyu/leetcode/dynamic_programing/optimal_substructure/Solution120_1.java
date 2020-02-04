package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;

import java.util.List;

/**
 * 记忆化搜索的解法
 */
public class Solution120_1 {
    private Integer[][] memory;

    public int minimumTotal(List<List<Integer>> triangle) {
        memory = new Integer[triangle.size() + 1][triangle.size() + 1];
        return minTotal(triangle, 0, 0);
    }

    public int minTotal(List<List<Integer>> triangle, int level, int n) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(n);
        }
        if (memory[level][n] == null) {
            int left = minTotal(triangle, level + 1, n);
            int right = minTotal(triangle, level + 1, n + 1);
            memory[level][n] = triangle.get(level).get(n) + Math.min(left, right);
        }
        return memory[level][n];
    }
}
