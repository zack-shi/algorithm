package com.zack.algorithm.backtracking;

import java.util.*;

/**
 * 491. 递增子序列
 */
public class IncreasingSubseq {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }


    public void backtracking(int[] nums, int startIndex) {
        if (list.size() >1) {
            result.add(new ArrayList<>(list));
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex &&!list.isEmpty() &&nums[i] <list.getLast()) {
                continue;
            }
            if(map.getOrDefault(nums[i],0)>0){
                continue;
            }
            map.put(nums[i],1);
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
