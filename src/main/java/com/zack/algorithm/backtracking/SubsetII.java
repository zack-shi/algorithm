package com.zack.algorithm.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 */
public class SubsetII {

    List<List<Integer>> result=new ArrayList<>();

    LinkedList<Integer> list=new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        backtracking(nums,0);
        return result;
    }



    public void backtracking(int[] nums,int startIndex){
        for(int i=startIndex;i<nums.length;i++){
            if(i>startIndex&&nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            backtracking(nums,i+1);
            list.removeLast();
        }
    }


}
