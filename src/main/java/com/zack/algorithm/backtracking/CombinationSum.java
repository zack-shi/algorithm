package com.zack.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            list.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, target,i);
            list.removeLast();
            sum = sum - candidates[i];
        }
    }

}
