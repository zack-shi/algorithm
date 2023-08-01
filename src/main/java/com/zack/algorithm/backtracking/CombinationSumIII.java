package com.zack.algorithm.backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class CombinationSumIII {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    int kk;
    int nn;
    int preSum = 0;


    public List<List<Integer>> combinationSum3(int k, int n) {
        kk = k;
        nn = n;
        backtracking(1, 9, 0);
        return result;
    }


    public void backtracking(int startIndex, int size, int preSum) {
        if (path.size() == kk) {
            if (preSum == nn) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < size - (kk - path.size()) + 1; i++) {
            preSum = preSum + i;
            path.add(i);
            backtracking(i + 1, size, preSum);
            path.removeLast();
            preSum = preSum - i;
            if (preSum == nn) {
                break;
            }
        }
    }

}
