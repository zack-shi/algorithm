package com.zack.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Combination {

    List<List<Integer>> result=new ArrayList<>();

    LinkedList<Integer> path =new LinkedList<>();


    public List<List<Integer>> combine(int n, int k) {
        backtracking(1,n,k);//从1开始
        return result;
    }

    public void backtracking(int startIndex,int n,int k){  //入参：起始位置startIndex,数组大小，组合大小
        if(path.size()==k){   //已经递归遍历到最深，已达组合个数
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<=n-(k-path.size())+1;i++){
            path.add(i);      // 记录当前数
            backtracking(i+1,n,k);  // 继续往下递归 相当于 每层继续往下写 for循环
            path.removeLast(); //移除到最后aad的 那个数，因为已经递归返回并加入到结果中了，要继续add下一个数了
        }
    }

}
