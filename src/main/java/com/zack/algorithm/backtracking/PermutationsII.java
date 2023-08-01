package com.zack.algorithm.backtracking;

import java.util.*;

public class PermutationsII {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    int [] used;


    public List<List<Integer>> permuteUnique(int[] nums) {
        used=new int[nums.length];
        Arrays.fill(used, 0);
        Arrays.sort(nums);
        backtrack(nums);
        return result;

    }

    public void backtrack(int[] nums){
        if (path.size() ==nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if(used[i]==1){
                continue;
            }
            used[i]=1;
            path.add(nums[i]);
            backtrack(nums);
            used[i]=0;
            path.removeLast();
        }
    }

}
