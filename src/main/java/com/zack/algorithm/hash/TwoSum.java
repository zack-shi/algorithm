package com.zack.algorithm.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int a[]=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }
        }
        return a;
    }

    Map<Integer,Integer> map=new HashMap<>();

    public int[] twoSum2(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int a[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int val=target-nums[i];
            if(val==nums[i]){
                continue;
            }
            if(map.containsKey(val)){
                a[0]=i;
                a[1]=map.get(val);
                return a;
            }
        }
        return a;
    }

}
