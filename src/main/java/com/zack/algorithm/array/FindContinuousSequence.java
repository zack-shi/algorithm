package com.zack.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {

    public int[][] findContinueSequence(int target) {
         int i=1;
         int j=2;
         int sum=i+j;
         List<int[]> res=new ArrayList<>();
         while (i<j){
             if(sum<target){
                 j++;
                 sum=sum+j;
             }else if(sum>target) {
                 sum=sum-i;
                 i++;
             }else {
                 //保存结果
                 int [] nums=new int[j-i+1];
                 for(int n=i;n<=j;n++){
                     nums[n-i]=n;
                 }
                 res.add(nums);
                 sum=sum-i;
                 i++;
             }
         }
         return res.toArray(new int[0][]);
    }



    public int[][] findContinuousSequence(int target) {
        if(target<=2){
            return new int[0][0];
        }
        List<List<Integer>> resList = getResList(target);
        int [] []ret=new int[resList.size()][];
        for(int i=0;i< resList.size();i++){
            int [] nums=new int[resList.get(i).size()];
            for(int j=0;j<nums.length;j++){
                nums[j]= resList.get(i).get(j);
            }
            ret[i]=nums;
        }
        return ret;
    }

    private static List<List<Integer>> getResList(int target) {
        List<List<Integer>> resList=new ArrayList<>();
        for(int i = 1; i< target; i++){
            int sum=i;
            List<Integer> sumList=new ArrayList<>();
            sumList.add(i);
            for(int j = i+1; j< target; j++){
                sum=sum+j;
                sumList.add(j);
                if(sum== target){
                    resList.add(sumList);
                    break;
                }
                if(sum> target){
                    break;
                }
            }
        }
        return resList;
    }
}
