package org.chenguoyu.leetcode.array;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                System.out.println(matrix[n - 1 - j][i]);
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                System.out.println(matrix[n - 1 - i][n - 1 - j]);
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                System.out.println(matrix[j][n - 1 - i]);
                matrix[j][n - 1 - i] = matrix[i][j];
                System.out.println(matrix[i][j]);
                matrix[i][j] = temp;
            }
        }
    }

    @Test
    public void main() {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
//        int[][] nums = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };

//        int[][] nums = new int[][]{
//                {5, 1, 9, 11},
//                {2, 4, 8, 10},
//                {13, 3, 6, 7},
//                {15, 14, 12, 16}
//        };
        rotate(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }
}
