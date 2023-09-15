package com.zack.algorithm.search;

public class RobotMovingCount {

    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.k=k;
        this.visited=new boolean[m][n];
        return dfs(0,0);
    }


    int dfs(int i,int j){
        if(i>=m||j>=n||numSum(i)+numSum(j)>k||visited[i][j]){
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i+1,j)+dfs(i,j+1);
    }

    int numSum(int num) {
        int m = num / 10;
        int n = num % 10;
        int sum = n;
        while (m > 0) {
            num = m;
            m = num / 10;
            n = num % 10;
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new RobotMovingCount().movingCount(16,8,4));
    }

}
