package org.chenguoyu.leetcode.dynamic_programing;

/**
 * 动态规划的解法
 */
public class Solution63_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rowSize = obstacleGrid.length;
        int colSize = obstacleGrid[0].length;
        Integer[][] memory = new Integer[rowSize][colSize];

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
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (obstacleGrid[i][j] == 1) {
                    memory[i][j] = 0;
                } else {
                    memory[i][j] = memory[i - 1][j] + memory[i][j - 1];
                }
            }
        }
        return memory[rowSize - 1][colSize - 1];
    }
}
