package org.chenguoyu.leetcode.trace_back;


/**
 * 岛屿数量
 */
public class Solution200 {
    private boolean[][] used;

    private int x, y;

    private int[][] area = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        used = new boolean[grid.length][grid[0].length];
        x = grid.length;
        y = grid[0].length;
        int result = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    result++;
                    numIslands(grid, i, j);
                }
            }
        }
        return result;
    }

    private void numIslands(char[][] grid, int startX, int startY) {
        if (!used[startX][startY]) {
            used[startX][startY] = true;
            for (int i = 0; i < area.length; i++) {
                int newX = startX + area[i][0];
                int newY = startY + area[i][1];
                if (inArea(newX, newY) && grid[newX][newY] == '1') {
                    numIslands(grid, newX, newY);
                }
            }
        }
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < x && newY >= 0 && newY < y;
    }
}
