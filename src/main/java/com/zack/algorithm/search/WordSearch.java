package com.zack.algorithm.search;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class WordSearch {

    int[][] record;
    char[] a;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.record = new int[board.length][board[0].length];
        this.board = board;
        int k = 0;
        this.a = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isExist = findNext(i, j, k);
                if (isExist) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNext(int i, int j, int k) {
        if (k >= a.length) {
            return true; //终止，满足条件
        }
        //越界、已访问、不等于word中对应的字母，这些情况任意一个不符合条件都不满足
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || record[i][j] == 1 || board[i][j] != a[k]) {
            return false;
        }
        record[i][j] = 1; //记录为已访问
        //继续尝试相邻的上下左右元素是否等于 word中的下一个字段
        boolean isNextOK = findNext(i - 1, j, k + 1) || findNext(i + 1, j, k + 1) || findNext(i, j - 1, k + 1) || findNext(i, j + 1, k + 1);
        if (isNextOK) {
            return true;
        }
        record[i][j] = 0; //撤回
        return false; //回溯
    }

}
