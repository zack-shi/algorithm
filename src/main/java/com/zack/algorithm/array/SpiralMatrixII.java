package com.zack.algorithm.array;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * 螺旋矩阵 II
 */
public class SpiralMatrixII {

    public static void main(String[] args) {

        int n=10;
        int[][] a= generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+",");
            }
            System.out.println();
        }
    }


    public static int[][] generateMatrix(int n) {
        int nn=n*n;
        int count=1;
        int i=0,j=0;
        int k=n;
        int [][]a=new int[n][n];

        while(n>0&&count<=nn){
            n=n-1;
            if(n==j&&n==i){
                a[i][j]=count;
                break;
            }
            for(;j<n;j++){
                a[i][j]=count;
                count++;
            }
            for(;i<n;i++){
                a[i][j]=count;
                count++;
            }
            for(;j>k-n-1;j--){
                a[i][j]=count;
                count++;
            }
            for(;i>k-n-1;i--){
                a[i][j]=count;
                count++;
            }
            i++;
            j++;
        }
        return a;
    }


}
