package com.zack.algorithm.greedy;

import com.alibaba.fastjson2.JSON;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> intervalList = new LinkedList<>();
        //根据end从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        intervalList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = intervalList.getLast();
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                intervalList.add(intervals[i]);
            }
        }
        int[][] a = new int[intervalList.size()][];
        return intervalList.toArray(a);
    }

    public static void main(String[] args) {
        int[][] intervals={{2,3},{4,5},{6,7},{8,9},{1,10}};
        intervals= new MergeIntervals().merge(intervals);
        System.out.println(JSON.toJSONString(intervals));
    }

}
