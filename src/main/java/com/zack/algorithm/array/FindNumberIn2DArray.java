package com.zack.algorithm.array;

/**
 * 剑指 Offer 04. 二维数组中的查找
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n=matrix.length;//行数
        if(n==0){
            return false;
        }
        int m=matrix[0].length;//列数
        //从最左下角开始
        int x=n-1;
        int y=0;
        while (x>=0&&y<m&&matrix[x][y]!=target){
            if(target>matrix[x][y]){
                y++;
            }else {
                x--;
            }
        }
        if(x<0||y==m){
            return false;
        }
        return true;
    }

}
