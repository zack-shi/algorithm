package com.zack.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int minStaminaRequired(int[][] tasks) {
        if(tasks.length==1){
            return tasks[0][1];
        }
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int sum=tasks[0][1];
        int res=sum-tasks[0][0];
        for(int i=1;i<tasks.length;i++){
            if(res>=tasks[i][1]){
                res=sum-tasks[i][0];
            }else {
                sum+=tasks[i][1]-res;
                res=tasks[i][1]-tasks[i][0];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
       int [][] plans = {{1,2},{1,7},{2,3},{5,9},{2,2}};
        System.out.println( new Solution2().minStaminaRequired(plans));
    }
}
