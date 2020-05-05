package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class Solution74 {
    /*
    输入:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    输出: true
    * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            int value = matrix[i][j];
            if (value > target) {
                i--;
            } else if (value < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void main() {
//        int[][] nums = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] nums = new int[][]{
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };
        int[][] nums = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        searchMatrix(nums, 13);
        System.out.println(1111);
    }
}
