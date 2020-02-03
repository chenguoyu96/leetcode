package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 记忆化搜索的解法
 */
public class Solution63_1 {
    private Integer[][] memory;
    private int rowSize;
    private int colSize;


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        rowSize = obstacleGrid.length;
        colSize = obstacleGrid[0].length;
        memory = new Integer[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            if (obstacleGrid[i][0] == 0) {
                memory[i][0] = 1;
            } else {
                for (int j = i; j < rowSize; j++) {
                    memory[j][0] = 0;
                }
                break;
            }
        }
        for (int i = 0; i < colSize; i++) {
            if (obstacleGrid[0][i] == 0) {
                memory[0][i] = 1;
            } else {
                for (int j = i; j < colSize; j++) {
                    memory[0][j] = 0;
                }
                break;
            }
        }
        return uniquePathsWithObstacles(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col) {
        if (row == -1 && col == -1) {
            return 0;
        }
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == 0 || col == 0) {
            return memory[row][col];
        }
        if (memory[row][col] == null) {
            memory[row][col] = uniquePathsWithObstacles(obstacleGrid, row - 1, col) + uniquePathsWithObstacles(obstacleGrid, row, col - 1);
        }
        return memory[row][col];
    }
}
