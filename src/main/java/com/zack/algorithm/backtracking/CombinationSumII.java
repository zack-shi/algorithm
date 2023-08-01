package com.zack.algorithm.backtracking;

import java.util.*;

public class CombinationSumII {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先排个序
        Arrays.sort(candidates);
        backtracking(candidates, target,0);
        return result;
    }


    public void backtracking(int[] candidates, int target,int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(i>index&&candidates[i]==candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, target,i+1);
            list.removeLast();
            sum = sum - candidates[i];
        }
    }
}
