package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;

/**
 * 记忆化搜索的解法
 */
public class Solution64_1 {
    Integer[][] memory;
    int rowSize, colSize;

    public int minPathSum(int[][] grid) {
        rowSize = grid.length;
        colSize = grid[0].length;
        memory = new Integer[rowSize + 1][colSize + 1];
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int row, int col) {
        if (row == (rowSize - 1) && col == (colSize - 1)) {
            return grid[row][col];
        }
        if (memory[row][col] == null) {
            int down = -1;
            if (row < (rowSize - 1)) {
                down = minPathSum(grid, row + 1, col);
            }
            int right = -1;
            if (col < (colSize - 1)) {
                right = minPathSum(grid, row, col + 1);
            }
            if (down == -1) {
                memory[row][col] = grid[row][col] + right;
            } else if (right == -1) {
                memory[row][col] = grid[row][col] + down;
            } else {
                memory[row][col] = grid[row][col] + Math.min(right, down);
            }
        }
        return memory[row][col];
    }
}
