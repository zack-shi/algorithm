package com.zack.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        List<int[]> list = new LinkedList<>();
        for(int i=0;i<people.length;i++){
            if(list.size()>people[i][1]){
                list.add(people[i][1],people[i]);
            }else {
                list.add(list.size(),people[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
