package com.zack.algorithm.array;

public class Solution {
    int[][] sumVal;
    public int maxInsuredArea(int[][] warehouses, int limit) {
        int m = warehouses.length;
        if (m > 0) {
            int n = warehouses[0].length;
            sumVal = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sumVal[i + 1][j + 1] = sumVal[i][j + 1] + sumVal[i + 1][j] - sumVal[i][j] + warehouses[i][j];
                }
            }
        }
        int k=0;
        if(warehouses.length>=warehouses[0].length){
            k=warehouses[0].length;
        }else {
            k=warehouses.length;
        }
        int maxLen=0;
        int x=1; //一个长度
       while (x<k){
           for(int i=0;i<warehouses.length;i++){
                for(int j=0;j<warehouses[0].length;j++){
                    if(x==1) {
                        int val=warehouses[i][j];
                        if(val<=limit){
                            maxLen=1;
                            break;
                        }
                    }else {
                        if(i+x-1<warehouses.length&&j+x-1<warehouses[0].length){
                            int val=sumRegion(i,j,i+x-1,j+x-1);
                            if(val<=limit){
                                maxLen=Math.max(maxLen,x);
                                break;
                            }
                        }
                    }
                }
           }
           x++;
       }
        return maxLen;
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumVal[row2 + 1][col2 + 1] - sumVal[row1][col2 + 1] - sumVal[row2 + 1][col1] + sumVal[row1][col1];
    }

}
