package com.zack.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  78. 子集
 */
public class Subset {


    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> list=new LinkedList<>();


    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        result.add(new ArrayList<>());
        return result;
    }


    public void backtracking(int[] nums,int startIndex){
        for(int i=startIndex;i<nums.length;i++){
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            backtracking(nums,i+1);
            list.removeLast();
        }
    }

}
