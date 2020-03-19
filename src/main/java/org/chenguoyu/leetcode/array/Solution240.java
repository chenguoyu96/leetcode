package org.chenguoyu.leetcode.array;


import org.junit.Test;

/**
 * 搜索二维矩阵 II
 */
public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return false;
        }
        int min = Math.min( matrix.length, matrix[0].length);
        for (int i = 0; i < min; i++) {
            if (binarySearchRow(matrix, target, i) || binarySearchCol(matrix, target, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearchCol(int[][] matrix, int target, int colIndex) {
        int top = 0;
        int bottom = matrix.length - 1;
        int middle;
        while (top <= bottom) {
            middle = (bottom - top) / 2 + top;
            int value = matrix[middle][colIndex];
            if (value == target) {
                return true;
            } else if (value < target) {
                top = middle + 1;
            } else {
                bottom = middle - 1;
            }
        }
        return false;
    }

    private boolean binarySearchRow(int[][] matrix, int target, int rowIndex) {
        int left = 0;
        int right = matrix[0].length - 1;
        int middle;
        while (left <= right) {
            middle = (right - left) / 2 + left;
            int value = matrix[rowIndex][middle];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }


    @Test
    public void main() {
        int[][] nums = new int[][]{{-1}, {-1}};
        System.out.println(searchMatrix(nums, 0));

    }
}
