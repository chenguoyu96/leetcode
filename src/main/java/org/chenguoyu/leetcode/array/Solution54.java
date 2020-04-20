package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Solution54 {
    /*
    输入:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    输出: [1,2,3,6,9,8,7,4,5]
    */
    private int rowLength, colLength;
    private boolean[][] used;
    private List<Integer> result;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        result = new ArrayList<>();
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        // 移动的坐标改变
        int[][] actions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        rowLength = matrix.length;
        colLength = matrix[0].length;
        used = new boolean[rowLength][colLength];
        int row = 0, col = 0, actionIndex = 0;
        for (int i = 0; i < rowLength * colLength; i++) {
            result.add(matrix[row][col]);
            used[row][col] = true;
            int rowTemp = row + actions[actionIndex][0];
            int colTemp = col + actions[actionIndex][1];
            if (inArea(rowTemp, colTemp) && !used[rowTemp][colTemp]) {
                row = rowTemp;
                col = colTemp;
            } else {
                actionIndex = ++actionIndex % 4;
                row = row + actions[actionIndex][0];
                col = col + actions[actionIndex][1];
            }
        }
        return result;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rowLength && col >= 0 && col < colLength;
    }


    @Test
    public void main() {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        spiralOrder(nums).stream().forEach(System.out::println);
    }
}
