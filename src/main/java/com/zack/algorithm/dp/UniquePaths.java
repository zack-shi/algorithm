package com.zack.algorithm.dp;

public class UniquePaths {

    int count = 0;
    int m;
    int n;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        int x = 0;
        int y = 0;
        move(x, y);
        return count;
    }


    void move(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            count++;
            return;
        }
        if (x < m - 1) {
            move(x + 1, y);
        }
        if (y < n - 1) {
            move(x, y + 1);
        }
    }

    public int uniquePath(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x - 1 < 0 || y - 1 < 0) {
                    dp[x][y] = 1;
                } else
                    dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
            }
        }
        return dp[m-1][n-1];
    }



    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePath(9, 8));
    }


}
