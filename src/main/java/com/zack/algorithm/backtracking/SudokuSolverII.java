package com.zack.algorithm.backtracking;

public class SudokuSolverII {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (board[a][b] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (valid(board, a, b, k)) {
                        board[a][b] = k;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[a][b] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     * 同行是否重复
     * 同列是否重复
     * 9宫格里是否重复
     */
    public boolean valid(char[][] board, int row, int col, char val) {
        int m = (row + 1) / 3;
        int r = (row + 1) % 3;
        if (r > 0) {
            m = m + 1;
        }
        int n = (col + 1) / 3;
        int t = (col + 1) % 3;
        if (t > 0) {
            n = n + 1;
        }
        //9宫格
        for (int i = m * 3 - 3; i < m * 3; i++) {
            for (int j = n * 3 - 3; j < n * 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        //当前行
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == '.') {
                continue;
            }
            if (board[row][j] == val) {
                return false;
            }
        }
        //当前列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') {
                continue;
            }
            if (board[i][col] == val) {
                return false;
            }
        }
        return true;
    }

}
