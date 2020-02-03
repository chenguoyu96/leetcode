package org.chenguoyu.leetcode.trace_back;


/**
 * 单词搜索
 */
public class Solution79 {
    private boolean[][] used;
    private int[][] area = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int x, y;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        used = new boolean[board.length][board[0].length];
        x = board.length;
        y = board[0].length;
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int colIndex = 0; colIndex < board[rowIndex].length; colIndex++) {
                if (board[rowIndex][colIndex] == word.charAt(0)) {
                    if (exist(board, word, 0, rowIndex, colIndex)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if (board[startX][startY] == word.charAt(index)) {
            used[startX][startY] = true;
            for (int j = 0; j < area.length; j++) {
                int newX = startX + area[j][0];
                int newY = startY + area[j][1];
                if (inArea(newX, newY)) {
                    if (!used[newX][newY]) {
                        if (exist(board, word, index + 1, newX, newY)) {
                            return true;
                        }
                    }
                }
            }
            used[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX < x && newX >= 0 && newY < y && newY >= 0;
    }
}
