package com.zack.algorithm.backtracking;

import java.util.*;

/**
 * 37. 解数独
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        List<int[]> indexList = new ArrayList<>();
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (board[a][b] == '.') {
                    indexList.add(new int[]{a, b});
                } else {
                    continue;
                }
            }
        }
        backtracking(board, indexList, 0);
    }


    //填充数字
    public boolean backtracking(char[][] board, List<int[]> indexList, int startIndex) {
        if(startIndex==indexList.size()){
            return true;
        }
        int[] index = indexList.get(startIndex);
        int row=index[0];
        int col=index[1];
        char [] availableNum = getRestNum(board, row, col);
        for (int i=0;i<availableNum.length; i++) {
            if(availableNum[i]!='.'){
                board[row][col] = availableNum[i];
                if(backtracking(board,indexList,startIndex+1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }


    /**
     * 寻找剩余可以填充的数
     *
     * @param board
     * @return
     */
    public char []  getRestNum(char[][] board, int row, int col) {
        char [] chars={'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int m = (row /3) * 3;
        int n = (col / 3) * 3;
        //移除掉3*3矩阵包括哪些数
        for (int i = m ; i < m + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    chars[board[i][j]-'0'-1]='.';
                }
            }
        }
        //移除当前行包括的数
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == '.') {
                continue;
            } else {
                chars[board[row][j]-'0'-1]='.';
            }
        }
        //移除当前列包括的数
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') {
                continue;
            } else {
                chars[board[i][col]-'0'-1]='.';
            }
        }
        //返回剩余的数
        return chars;
    }


    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SudokuSolver().solveSudoku(board);
    }


}
