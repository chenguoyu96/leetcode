package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 太平洋大西洋水流问题
 */
public class Solution417 {
    private boolean[][] used;

    private int x, y;
    private int[][] area = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        y = matrix.length;
        x = matrix[0].length;
        used = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (pacificAtlantic(matrix, i, j) && pacificAtlanticY(matrix, i, j)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private boolean pacificAtlantic(int[][] matrix, int startY, int startX) {
        if (startY <= 0 || startX <= 0) {
            return true;
        }
        used[startY][startX] = true;
        for (int i = 0; i < area.length; i++) {
            int newX = startX + area[i][1];
            int newY = startY + area[i][0];
            if (inArea(newX, newY) && !used[newY][newX] && matrix[startY][startX] >= matrix[newY][newX]) {
                if (pacificAtlantic(matrix, newY, newX)) {
                    used[startY][startX] = false;
                    return true;
                }
            }
        }
        used[startY][startX] = false;
        return false;
    }

    private boolean pacificAtlanticY(int[][] matrix, int startY, int startX) {
        if (startY >= (y - 1) || startX >= (x - 1)) {
            return true;
        }
        used[startY][startX] = true;
        for (int i = 0; i < area.length; i++) {
            int newX = startX + area[i][1];
            int newY = startY + area[i][0];
            if (inArea(newX, newY) && !used[newY][newX] && matrix[startY][startX] >= matrix[newY][newX]) {
                if (pacificAtlanticY(matrix, newY, newX)) {
                    used[startY][startX] = false;
                    return true;
                }
            }
        }
        used[startY][startX] = false;
        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < x && newY >= 0 && newY < y;
    }
}
