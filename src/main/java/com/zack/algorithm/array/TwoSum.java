package com.zack.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {


    Set<Integer> set=new HashSet<>();

    /**
     * hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==1){
            return nums;
        }
        for(int num:nums){
            set.add(num);
        }
        int [] ret=new int[2];
        for(int num:nums){
            int res=target-num;
            if(set.contains(res)){
                ret[0]=num;
                ret[1]=res;
                return ret;
            }
        }
        return ret;
    }

    /**
     * 双指针
     */
    public int[] twoSumByTwoPoint(int[] nums, int target) {
        if(nums.length==1){
            return nums;
        }
        int i=0;
        int j=nums.length-1;
        int [] ret=new int[2];
        while (i<j){
            int sum =nums[i]+nums[j];
            if(sum==target){
                ret[0]=nums[i];
                ret[1]=nums[j];
                return ret;
            } else if(sum>target){
                j--;
            }else {
                i++;
            }
        }
        return ret;
    }
}
