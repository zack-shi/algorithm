package com.zack.algorithm.backtracking;



import java.util.*;

/**
 * 46. 全排列
 */
public class Permutation {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    int [] used;


    public List<List<Integer>> permute(int[] nums) {
        used=new int[nums.length];
        backtrack(nums);
        return result;

    }

    public void backtrack(int[] nums){
        if (path.size() ==nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
       for(int i=0;i<nums.length;i++){
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
