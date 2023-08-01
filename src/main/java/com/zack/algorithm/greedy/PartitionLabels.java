package com.zack.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int [] last=new int[26];
        for(int i=0; i<s.length();i++){
            last[s.charAt(i)-97]=i;
        }
        List<Integer> list=new ArrayList<>();
        int maxLast=0;
        int start=0;
        for(int i=0; i<s.length();i++){
            int currLast=last[s.charAt(i)-97];
            if(currLast>i){
                maxLast=Math.max(maxLast,currLast);
                continue;
            }
            if(currLast==i&&currLast==maxLast){
                list.add(i+1-start);
                start=i+1;
                maxLast=last[s.charAt(start)-97];
            }
        }
        return list;
    }

}
