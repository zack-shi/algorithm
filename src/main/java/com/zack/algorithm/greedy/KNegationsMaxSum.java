package com.zack.algorithm.greedy;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 */
public class KNegationsMaxSum {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int count=0;
        int minIndex=0;
        while (count<k){
            int min=Integer.MAX_VALUE;
            //每次找最小的值，取反
            for(int i=0;i<nums.length;i++){
                if(nums[i]<min){
                    min=nums[i];
                    minIndex=i;
                }
            }
            nums[minIndex]=-nums[minIndex];
            count++;
        }
        //计算和
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[]={2,-3,-1,5,-4};
        int k=2;
        System.out.println(new KNegationsMaxSum().largestSumAfterKNegations(nums,k));
    }


}
