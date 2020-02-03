package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 动态规划的解法
 */
public class Solution64_2 {
    public int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        Integer[][] memory = new Integer[grid.length][grid[0].length];
        for (int row = rowSize - 1; row >= 0; row--) {
            for (int col = colSize - 1; col >= 0; col--) {
                if (row == (rowSize - 1) && col == (colSize - 1)) {
                    memory[row][col] = grid[row][col];
                } else if (row == (rowSize - 1) && col != (colSize - 1)) {
                    memory[row][col] = grid[row][col] + memory[row][col + 1];
                } else if (row != (rowSize - 1) && col == (colSize - 1)) {
                    memory[row][col] = grid[row][col] + memory[row + 1][col];
                } else {
                    memory[row][col] = grid[row][col] + Math.min(memory[row + 1][col], memory[row][col + 1]);
                }
            }
        }
        return memory[0][0];
    }
}
