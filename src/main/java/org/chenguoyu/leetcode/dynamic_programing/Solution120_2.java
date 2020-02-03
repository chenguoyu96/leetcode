package org.chenguoyu.leetcode.dynamic_programing;

import java.util.List;

/**
 * 动态规划的解法
 */
public class Solution120_2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] memory = new int[triangle.size() + 1];
        for (int level = triangle.size() - 1; level >= 0; level--) {
            for (int j = 0; j <= level; j++) {
                memory[j] = Math.min(memory[j], memory[j + 1]) + triangle.get(level).get(j);
            }
        }
        return memory[0];
    }
}
