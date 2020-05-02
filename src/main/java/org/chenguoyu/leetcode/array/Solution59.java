package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Solution59 {

    public int[][] generateMatrix(int n) {
        int length = n * n;
        int[][] result = new int[n][n];
        boolean[][] used = new boolean[n][n];
        int[][] directs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direct = 0, row = 0, col = 0;
        for (int i = 0; i < length; i++) {
            result[row][col] = i + 1;
            used[row][col] = true;
            int rowTemp = row + directs[direct][0];
            int colTemp = col + directs[direct][1];
            if (rowTemp < n && colTemp < n && rowTemp >= 0 && colTemp >= 0 && !used[rowTemp][colTemp]){
                row = rowTemp;
                col = colTemp;
            } else{
                direct = (direct + 1) % 4;
                row += directs[direct][0];
                col += directs[direct][1];
            }
        }
        return result;
    }

    @Test
    public void main() {

        generateMatrix(3);
    }
}
