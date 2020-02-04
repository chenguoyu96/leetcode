package org.chenguoyu.leetcode.trace_back.flood_fill;


/**
 * 被围绕的区域
 */
public class Solution130 {
    private boolean[][] used;

    private int x, y;

    private int[][] area = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        used = new boolean[board.length][board[0].length];
        x = board.length;
        y = board[0].length;
        for (int i = 0; i < y; i++) {
            solve(board, 0, i);
            solve(board, x - 1, i);
        }
        for (int i = 1; i < x - 1; i++) {
            solve(board, i, 0);
            solve(board, i, y - 1);
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!used[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void solve(char[][] board, int startX, int startY) {
        if (!used[startX][startY] && board[startX][startY] == 'O') {
            used[startX][startY] = true;
            for (int i = 0; i < area.length; i++) {
                int newX = startX + area[i][0];
                int newY = startY + area[i][1];
                if (inArea(newX, newY)) {
                    solve(board, newX, newY);
                }
            }
        }
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < x && newY >= 0 && newY < y;
    }
}
