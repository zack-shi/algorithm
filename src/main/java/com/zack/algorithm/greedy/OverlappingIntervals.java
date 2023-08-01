package com.zack.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class OverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        //按起始位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }else if (o1[0]==o2[0]){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        int count=0;
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                count++;
                end=Math.min(end,intervals[i][1]);
            }else {
                end=intervals[i][1];
            }
        }
        return count;
    }

}
